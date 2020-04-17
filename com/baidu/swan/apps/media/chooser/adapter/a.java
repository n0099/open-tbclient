package com.baidu.swan.apps.media.chooser.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.util.media.MimeType;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.ac;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.media.chooser.b.d;
import com.baidu.swan.apps.media.chooser.c.e;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.webkit.sdk.PermissionRequest;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private Activity caH;
    private ArrayList<MediaModel> caI = new ArrayList<>();
    public e caJ;
    private FrameLayout.LayoutParams caK;
    private int mItemHeight;
    private int mItemWidth;

    public a(Activity activity) {
        this.caH = activity;
        int displayWidth = af.getDisplayWidth(this.caH);
        int displayHeight = af.getDisplayHeight(this.caH);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.caK = new FrameLayout.LayoutParams((displayWidth - af.dip2px(this.caH, 10.0f)) / 4, (displayWidth - af.dip2px(this.caH, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.caJ = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.caI.size() > 0) {
            this.caI.clear();
        }
        this.caI.addAll(arrayList);
        d.o(this.caI);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.caI.size() + 1 : this.caI.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.caI.get(i - 1);
        }
        return this.caI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (d.mIsShowCamera && i == 0) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0296a c0296a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.caH).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            al(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.caH).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0296a c0296a2 = new C0296a(view);
            view.setTag(c0296a2);
            c0296a = c0296a2;
        } else {
            c0296a = (C0296a) view.getTag();
        }
        a(c0296a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0296a);
            a(mediaModel, c0296a, i);
            b(mediaModel, c0296a, i);
            return view;
        }
        return view;
    }

    private void al(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.caK);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.caX, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.afB();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.afD();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afB() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cbC) {
            d.ku(d.mMode);
        } else {
            bZ(this.caH);
        }
    }

    private void bZ(Context context) {
        com.baidu.swan.apps.af.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.af.b
            public void gQ(String str) {
                a.this.afC();
            }

            @Override // com.baidu.swan.apps.af.b
            public void M(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afC() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.caH, d.cbD, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void t(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.bZN);
                bundle.putString("swanAppId", d.cbD);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.afJ());
                bundle.putString("swanTmpPath", d.cbF);
                d.c(a.this.caH, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void kq(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afD() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cbC) {
            d.ku(d.mMode);
        } else if (ac.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.caH.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            ca(this.caH);
        }
    }

    private void ca(Context context) {
        com.baidu.swan.apps.af.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.af.b
            public void gQ(String str) {
                a.this.afE();
            }

            @Override // com.baidu.swan.apps.af.b
            public void M(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afE() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.caH, d.cbD, d.cbE, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void t(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.u(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.bZN);
                bundle.putString("swanAppId", d.cbD);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.afJ());
                bundle.putString("swanTmpPath", d.cbF);
                d.c(a.this.caH, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void kq(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0296a c0296a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0296a.caS.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0296a.caR.setVisibility(0);
            c0296a.caR.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0296a.caQ.setVisibility(0);
        } else {
            c0296a.caQ.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.cbA) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0296a.caV.setText(this.caH.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0296a.caW.setVisibility(8);
                }
            } else {
                c0296a.caV.setText(this.caH.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0296a.caW.setVisibility(8);
        }
        c0296a.caU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0296a);
            }
        });
        c0296a.caP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0296a c0296a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0296a.caW.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0296a.caW.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.caH.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.caH.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.caH.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0296a.caW.setLayoutParams(layoutParams);
            c0296a.caV.setText(aQ(videoModel.getDuration()));
            c0296a.caP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.kr(videoModel.getPath()) && !a.this.aR(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0296a c0296a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.cbC) {
                d.ku(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.afK(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.k(this.caH, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0296a.caS.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0296a.caR.setVisibility(0);
                c0296a.caR.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0296a.caT.startAnimation(AnimationUtils.loadAnimation(this.caH, a.C0227a.swanapp_album_checkshake));
                if (this.caJ != null) {
                    this.caJ.ft(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0296a.caS.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0296a.caR.setVisibility(8);
        if (this.caJ != null) {
            this.caJ.ft(selectedCount);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, int i) {
        if (!d.a(d.mMode, mediaModel)) {
            if (d.mIsShowCamera) {
                i--;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.bZN);
            bundle.putString("swanAppId", d.cbD);
            bundle.putString("mode", d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.caH, bundle);
        }
    }

    private void a(C0296a c0296a, View view) {
        Resources resources = this.caH.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0296a.caP.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0296a.caR.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0296a.caW.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0296a.caV.setTextColor(resources.getColor(a.c.aiapps_white));
        c0296a.caQ.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0296a.caP.setLayoutParams(this.caK);
        c0296a.caQ.setLayoutParams(this.caK);
        c0296a.caQ.setVisibility(8);
        c0296a.caR.setVisibility(8);
        c0296a.caU.setVisibility(8);
        c0296a.caW.setVisibility(8);
        c0296a.caU.setVisibility(0);
        c0296a.caS.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0296a.caW.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0296a.caW.getLayoutParams();
        layoutParams.width = this.caH.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.caH.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0296a.caW.setLayoutParams(layoutParams);
    }

    private void a(String str, C0296a c0296a) {
        ImageRequestBuilder Z = ImageRequestBuilder.Z(Uri.fromFile(new File(str)));
        Z.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        Z.vQ(true);
        Z.a(com.facebook.imagepipeline.common.b.dqK().vI(true).dqS());
        c0296a.caP.setController(com.facebook.drawee.a.a.c.dnP().aW(Z.duW()).vC(false).c(c0296a.caP.getController()).doG());
    }

    private String aQ(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 % 60));
        if (j3 == 0) {
            return this.caH.getString(a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.caH.getString(a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j3)), format, format2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kr(String str) {
        String str2 = "";
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            str2 = mediaMetadataRetriever.extractMetadata(12);
        } catch (Exception e) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str2) && str2.startsWith("video/")) {
            return TextUtils.equals(MimeType.Video.MP4, str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals("video/webm", str2) || TextUtils.equals("video/mkv", str2);
        }
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.caH.getString(a.h.swanapp_album_video_format)).showToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aR(long j) {
        if (j < 3000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.caH.getString(a.h.swanapp_album_video_duration_min)).showToast();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.caH.getString(a.h.swanapp_album_video_duration_max)).showToast();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0296a {
        private SimpleDraweeView caP;
        private ImageView caQ;
        private TextView caR;
        private ImageView caS;
        private View caT;
        private View caU;
        private TextView caV;
        private View caW;

        public C0296a(View view) {
            this.caP = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.caS = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.caR = (TextView) view.findViewById(a.f.album_item_select_number);
            this.caU = view.findViewById(a.f.album_item_selected_check);
            this.caT = view.findViewById(a.f.album_item_select_circle_view);
            this.caQ = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.caW = view.findViewById(a.f.album_item_tip_bg);
            this.caV = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
