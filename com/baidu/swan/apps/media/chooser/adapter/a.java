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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private Activity bFt;
    private ArrayList<MediaModel> cOi = new ArrayList<>();
    public e cOj;
    private int mItemHeight;
    private int mItemWidth;
    private FrameLayout.LayoutParams mLayoutParams;

    public a(Activity activity) {
        this.bFt = activity;
        int displayWidth = ah.getDisplayWidth(this.bFt);
        int displayHeight = ah.getDisplayHeight(this.bFt);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.mLayoutParams = new FrameLayout.LayoutParams((displayWidth - ah.dip2px(this.bFt, 10.0f)) / 4, (displayWidth - ah.dip2px(this.bFt, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.cOj = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.cOi.size() > 0) {
            this.cOi.clear();
        }
        this.cOi.addAll(arrayList);
        d.t(this.cOi);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.cOi.size() + 1 : this.cOi.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.cOi.get(i - 1);
        }
        return this.cOi.get(i);
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
        C0427a c0427a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.bFt).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            as(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.bFt).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0427a c0427a2 = new C0427a(view);
            view.setTag(c0427a2);
            c0427a = c0427a2;
        } else {
            c0427a = (C0427a) view.getTag();
        }
        a(c0427a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0427a);
            a(mediaModel, c0427a, i);
            b(mediaModel, c0427a, i);
            return view;
        }
        return view;
    }

    private void as(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.mLayoutParams);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.cIJ, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.awt();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.awv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awt() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cPa) {
            d.pv(d.mMode);
        } else {
            cn(this.bFt);
        }
    }

    private void cn(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.ab.b
            public void jL(String str) {
                a.this.awu();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void Z(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awu() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.bFt, d.cPb, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void E(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.cNq);
                bundle.putString("swanAppId", d.cPb);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.awB());
                bundle.putString("swanTmpPath", d.cPd);
                d.c(a.this.bFt, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void pr(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awv() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cPa) {
            d.pv(d.mMode);
        } else if (af.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bFt.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            co(this.bFt);
        }
    }

    private void co(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.ab.b
            public void jL(String str) {
                a.this.aww();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void Z(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aww() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.bFt, d.cPb, d.cPc, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void E(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.F(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.cNq);
                bundle.putString("swanAppId", d.cPb);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.awB());
                bundle.putString("swanTmpPath", d.cPd);
                d.c(a.this.bFt, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void pr(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0427a c0427a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0427a.cOr.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0427a.cOq.setVisibility(0);
            c0427a.cOq.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0427a.cOp.setVisibility(0);
        } else {
            c0427a.cOp.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.cOY) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0427a.cOu.setText(this.bFt.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0427a.cOv.setVisibility(8);
                }
            } else {
                c0427a.cOu.setText(this.bFt.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0427a.cOv.setVisibility(8);
        }
        c0427a.cOt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0427a);
            }
        });
        c0427a.cOo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0427a c0427a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0427a.cOv.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0427a.cOv.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.bFt.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.bFt.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.bFt.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0427a.cOv.setLayoutParams(layoutParams);
            c0427a.cOu.setText(bp(videoModel.getDuration()));
            c0427a.cOo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.ps(videoModel.getPath()) && !a.this.bq(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0427a c0427a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.cPa) {
                d.pv(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.awC(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.k(this.bFt, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0427a.cOr.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0427a.cOq.setVisibility(0);
                c0427a.cOq.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0427a.cOs.startAnimation(AnimationUtils.loadAnimation(this.bFt, a.C0343a.swanapp_album_checkshake));
                if (this.cOj != null) {
                    this.cOj.iP(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0427a.cOr.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0427a.cOq.setVisibility(8);
        if (this.cOj != null) {
            this.cOj.iP(selectedCount);
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
            bundle.putBoolean("compressed", d.cNq);
            bundle.putString("swanAppId", d.cPb);
            bundle.putString("mode", d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.bFt, bundle);
        }
    }

    private void a(C0427a c0427a, View view) {
        Resources resources = this.bFt.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0427a.cOo.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0427a.cOq.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0427a.cOv.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0427a.cOu.setTextColor(resources.getColor(a.c.aiapps_white));
        c0427a.cOp.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0427a.cOo.setLayoutParams(this.mLayoutParams);
        c0427a.cOp.setLayoutParams(this.mLayoutParams);
        c0427a.cOp.setVisibility(8);
        c0427a.cOq.setVisibility(8);
        c0427a.cOt.setVisibility(8);
        c0427a.cOv.setVisibility(8);
        c0427a.cOt.setVisibility(0);
        c0427a.cOr.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0427a.cOv.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0427a.cOv.getLayoutParams();
        layoutParams.width = this.bFt.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.bFt.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0427a.cOv.setLayoutParams(layoutParams);
    }

    private void a(String str, C0427a c0427a) {
        ImageRequestBuilder ad = ImageRequestBuilder.ad(Uri.fromFile(new File(str)));
        ad.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        ad.za(true);
        ad.a(com.facebook.imagepipeline.common.b.dZY().yS(true).eag());
        c0427a.cOo.setController(com.facebook.drawee.a.a.c.dXf().bj(ad.eej()).yM(false).c(c0427a.cOo.getController()).dXW());
    }

    private String bp(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 % 60));
        if (j3 == 0) {
            return this.bFt.getString(a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.bFt.getString(a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j3)), format, format2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ps(String str) {
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
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bFt.getString(a.h.swanapp_album_video_format)).showToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bq(long j) {
        if (j < IMConnection.RETRY_DELAY_TIMES) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bFt.getString(a.h.swanapp_album_video_duration_min)).showToast();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bFt.getString(a.h.swanapp_album_video_duration_max)).showToast();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0427a {
        private SimpleDraweeView cOo;
        private ImageView cOp;
        private TextView cOq;
        private ImageView cOr;
        private View cOs;
        private View cOt;
        private TextView cOu;
        private View cOv;

        public C0427a(View view) {
            this.cOo = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.cOr = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.cOq = (TextView) view.findViewById(a.f.album_item_select_number);
            this.cOt = view.findViewById(a.f.album_item_selected_check);
            this.cOs = view.findViewById(a.f.album_item_select_circle_view);
            this.cOp = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.cOv = view.findViewById(a.f.album_item_tip_bg);
            this.cOu = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
