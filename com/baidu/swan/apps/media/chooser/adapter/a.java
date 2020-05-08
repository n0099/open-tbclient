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
    private Activity caN;
    private ArrayList<MediaModel> caO = new ArrayList<>();
    public e caP;
    private FrameLayout.LayoutParams caQ;
    private int mItemHeight;
    private int mItemWidth;

    public a(Activity activity) {
        this.caN = activity;
        int displayWidth = af.getDisplayWidth(this.caN);
        int displayHeight = af.getDisplayHeight(this.caN);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.caQ = new FrameLayout.LayoutParams((displayWidth - af.dip2px(this.caN, 10.0f)) / 4, (displayWidth - af.dip2px(this.caN, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.caP = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.caO.size() > 0) {
            this.caO.clear();
        }
        this.caO.addAll(arrayList);
        d.o(this.caO);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.caO.size() + 1 : this.caO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.caO.get(i - 1);
        }
        return this.caO.get(i);
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
        C0317a c0317a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.caN).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            al(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.caN).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0317a c0317a2 = new C0317a(view);
            view.setTag(c0317a2);
            c0317a = c0317a2;
        } else {
            c0317a = (C0317a) view.getTag();
        }
        a(c0317a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0317a);
            a(mediaModel, c0317a, i);
            b(mediaModel, c0317a, i);
            return view;
        }
        return view;
    }

    private void al(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.caQ);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.cbd, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.afA();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.afC();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afA() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cbI) {
            d.ku(d.mMode);
        } else {
            bN(this.caN);
        }
    }

    private void bN(Context context) {
        com.baidu.swan.apps.af.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.af.b
            public void gQ(String str) {
                a.this.afB();
            }

            @Override // com.baidu.swan.apps.af.b
            public void M(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afB() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.caN, d.cbJ, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void t(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.bZT);
                bundle.putString("swanAppId", d.cbJ);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.afI());
                bundle.putString("swanTmpPath", d.cbL);
                d.c(a.this.caN, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void kq(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afC() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cbI) {
            d.ku(d.mMode);
        } else if (ac.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.caN.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            bO(this.caN);
        }
    }

    private void bO(Context context) {
        com.baidu.swan.apps.af.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.af.b
            public void gQ(String str) {
                a.this.afD();
            }

            @Override // com.baidu.swan.apps.af.b
            public void M(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afD() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.caN, d.cbJ, d.cbK, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void t(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.u(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.bZT);
                bundle.putString("swanAppId", d.cbJ);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.afI());
                bundle.putString("swanTmpPath", d.cbL);
                d.c(a.this.caN, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void kq(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0317a c0317a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0317a.caY.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0317a.caX.setVisibility(0);
            c0317a.caX.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0317a.caW.setVisibility(0);
        } else {
            c0317a.caW.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.cbG) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0317a.cbb.setText(this.caN.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0317a.cbc.setVisibility(8);
                }
            } else {
                c0317a.cbb.setText(this.caN.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0317a.cbc.setVisibility(8);
        }
        c0317a.cba.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0317a);
            }
        });
        c0317a.caV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0317a c0317a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0317a.cbc.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0317a.cbc.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.caN.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.caN.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.caN.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0317a.cbc.setLayoutParams(layoutParams);
            c0317a.cbb.setText(aQ(videoModel.getDuration()));
            c0317a.caV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
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
    public void a(MediaModel mediaModel, C0317a c0317a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.cbI) {
                d.ku(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.afJ(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.k(this.caN, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0317a.caY.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0317a.caX.setVisibility(0);
                c0317a.caX.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0317a.caZ.startAnimation(AnimationUtils.loadAnimation(this.caN, a.C0248a.swanapp_album_checkshake));
                if (this.caP != null) {
                    this.caP.ft(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0317a.caY.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0317a.caX.setVisibility(8);
        if (this.caP != null) {
            this.caP.ft(selectedCount);
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
            bundle.putBoolean("compressed", d.bZT);
            bundle.putString("swanAppId", d.cbJ);
            bundle.putString("mode", d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.caN, bundle);
        }
    }

    private void a(C0317a c0317a, View view) {
        Resources resources = this.caN.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0317a.caV.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0317a.caX.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0317a.cbc.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0317a.cbb.setTextColor(resources.getColor(a.c.aiapps_white));
        c0317a.caW.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0317a.caV.setLayoutParams(this.caQ);
        c0317a.caW.setLayoutParams(this.caQ);
        c0317a.caW.setVisibility(8);
        c0317a.caX.setVisibility(8);
        c0317a.cba.setVisibility(8);
        c0317a.cbc.setVisibility(8);
        c0317a.cba.setVisibility(0);
        c0317a.caY.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0317a.cbc.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0317a.cbc.getLayoutParams();
        layoutParams.width = this.caN.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.caN.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0317a.cbc.setLayoutParams(layoutParams);
    }

    private void a(String str, C0317a c0317a) {
        ImageRequestBuilder Z = ImageRequestBuilder.Z(Uri.fromFile(new File(str)));
        Z.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        Z.vQ(true);
        Z.a(com.facebook.imagepipeline.common.b.dqH().vI(true).dqP());
        c0317a.caV.setController(com.facebook.drawee.a.a.c.dnM().aX(Z.duT()).vC(false).c(c0317a.caV.getController()).doD());
    }

    private String aQ(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 % 60));
        if (j3 == 0) {
            return this.caN.getString(a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.caN.getString(a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j3)), format, format2});
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
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.caN.getString(a.h.swanapp_album_video_format)).showToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aR(long j) {
        if (j < 3000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.caN.getString(a.h.swanapp_album_video_duration_min)).showToast();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.caN.getString(a.h.swanapp_album_video_duration_max)).showToast();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0317a {
        private SimpleDraweeView caV;
        private ImageView caW;
        private TextView caX;
        private ImageView caY;
        private View caZ;
        private View cba;
        private TextView cbb;
        private View cbc;

        public C0317a(View view) {
            this.caV = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.caY = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.caX = (TextView) view.findViewById(a.f.album_item_select_number);
            this.cba = view.findViewById(a.f.album_item_selected_check);
            this.caZ = view.findViewById(a.f.album_item_select_circle_view);
            this.caW = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.cbc = view.findViewById(a.f.album_item_tip_bg);
            this.cbb = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
