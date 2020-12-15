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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.util.media.MimeType;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.af;
import com.baidu.swan.apps.ap.ah;
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
/* loaded from: classes25.dex */
public class a extends BaseAdapter {
    private Activity beD;
    private ArrayList<MediaModel> dhO = new ArrayList<>();
    public e dhP;
    private int mItemHeight;
    private int mItemWidth;
    private FrameLayout.LayoutParams mLayoutParams;

    public a(Activity activity) {
        this.beD = activity;
        int displayWidth = ah.getDisplayWidth(this.beD);
        int displayHeight = ah.getDisplayHeight(this.beD);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.mLayoutParams = new FrameLayout.LayoutParams((displayWidth - ah.dip2px(this.beD, 10.0f)) / 4, (displayWidth - ah.dip2px(this.beD, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.dhP = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.dhO.size() > 0) {
            this.dhO.clear();
        }
        this.dhO.addAll(arrayList);
        d.t(this.dhO);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.dhO.size() + 1 : this.dhO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.dhO.get(i - 1);
        }
        return this.dhO.get(i);
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
        C0463a c0463a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.beD).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            az(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.beD).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0463a c0463a2 = new C0463a(view);
            view.setTag(c0463a2);
            c0463a = c0463a2;
        } else {
            c0463a = (C0463a) view.getTag();
        }
        a(c0463a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0463a);
            a(mediaModel, c0463a, i);
            b(mediaModel, c0463a, i);
            return view;
        }
        return view;
    }

    private void az(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.mLayoutParams);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.dck, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.aDo();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aDq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDo() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.diJ) {
            d.qD(d.mMode);
        } else {
            cT(this.beD);
        }
    }

    private void cT(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.ab.b
            public void kU(String str) {
                a.this.aDp();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void af(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDp() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.beD, d.diK, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void D(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.dgW);
                bundle.putString("swanAppId", d.diK);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aDw());
                bundle.putString("swanTmpPath", d.diM);
                d.c(a.this.beD, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void qz(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDq() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.diJ) {
            d.qD(d.mMode);
        } else if (af.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.beD.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            cU(this.beD);
        }
    }

    private void cU(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.ab.b
            public void kU(String str) {
                a.this.aDr();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void af(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDr() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.beD, d.diK, d.diL, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void D(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.E(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.dgW);
                bundle.putString("swanAppId", d.diK);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aDw());
                bundle.putString("swanTmpPath", d.diM);
                d.c(a.this.beD, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void qz(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0463a c0463a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0463a.dhX.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0463a.dhW.setVisibility(0);
            c0463a.dhW.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0463a.dhV.setVisibility(0);
        } else {
            c0463a.dhV.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.diH) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0463a.dia.setText(this.beD.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0463a.dib.setVisibility(8);
                }
            } else {
                c0463a.dia.setText(this.beD.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0463a.dib.setVisibility(8);
        }
        c0463a.dhZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0463a);
            }
        });
        c0463a.dhU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0463a c0463a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0463a.dib.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0463a.dib.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.beD.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.beD.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.beD.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0463a.dib.setLayoutParams(layoutParams);
            c0463a.dia.setText(cm(videoModel.getDuration()));
            c0463a.dhU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.qA(videoModel.getPath()) && !a.this.cn(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0463a c0463a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.diJ) {
                d.qD(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.aDx(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.t(this.beD, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0463a.dhX.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0463a.dhW.setVisibility(0);
                c0463a.dhW.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0463a.dhY.startAnimation(AnimationUtils.loadAnimation(this.beD, a.C0379a.swanapp_album_checkshake));
                if (this.dhP != null) {
                    this.dhP.jE(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0463a.dhX.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0463a.dhW.setVisibility(8);
        if (this.dhP != null) {
            this.dhP.jE(selectedCount);
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
            bundle.putBoolean("compressed", d.dgW);
            bundle.putString("swanAppId", d.diK);
            bundle.putString(UbcStatConstant.KEY_CONTENT_EXT_MODE, d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.beD, bundle);
        }
    }

    private void a(C0463a c0463a, View view) {
        Resources resources = this.beD.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0463a.dhU.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0463a.dhW.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0463a.dib.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0463a.dia.setTextColor(resources.getColor(a.c.aiapps_white));
        c0463a.dhV.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0463a.dhU.setLayoutParams(this.mLayoutParams);
        c0463a.dhV.setLayoutParams(this.mLayoutParams);
        c0463a.dhV.setVisibility(8);
        c0463a.dhW.setVisibility(8);
        c0463a.dhZ.setVisibility(8);
        c0463a.dib.setVisibility(8);
        c0463a.dhZ.setVisibility(0);
        c0463a.dhX.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0463a.dib.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0463a.dib.getLayoutParams();
        layoutParams.width = this.beD.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.beD.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0463a.dib.setLayoutParams(layoutParams);
    }

    private void a(String str, C0463a c0463a) {
        ImageRequestBuilder af = ImageRequestBuilder.af(Uri.fromFile(new File(str)));
        af.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        af.Bb(true);
        af.a(com.facebook.imagepipeline.common.b.ets().AV(true).etA());
        c0463a.dhU.setController(com.facebook.drawee.a.a.c.eqG().bo(af.exx()).AP(false).c(c0463a.dhU.getController()).erx());
    }

    private String cm(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 % 60));
        if (j3 == 0) {
            return this.beD.getString(a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.beD.getString(a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j3)), format, format2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qA(String str) {
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
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.beD.getString(a.h.swanapp_album_video_format)).showToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cn(long j) {
        if (j < IMConnection.RETRY_DELAY_TIMES) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.beD.getString(a.h.swanapp_album_video_duration_min)).showToast();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.beD.getString(a.h.swanapp_album_video_duration_max)).showToast();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class C0463a {
        private SimpleDraweeView dhU;
        private ImageView dhV;
        private TextView dhW;
        private ImageView dhX;
        private View dhY;
        private View dhZ;
        private TextView dia;
        private View dib;

        public C0463a(View view) {
            this.dhU = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.dhX = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.dhW = (TextView) view.findViewById(a.f.album_item_select_number);
            this.dhZ = view.findViewById(a.f.album_item_selected_check);
            this.dhY = view.findViewById(a.f.album_item_select_circle_view);
            this.dhV = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.dib = view.findViewById(a.f.album_item_tip_bg);
            this.dia = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
