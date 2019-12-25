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
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private ArrayList<MediaModel> bxi = new ArrayList<>();
    public e bxj;
    private FrameLayout.LayoutParams bxk;
    private Activity mContext;
    private int mItemHeight;
    private int mItemWidth;

    public a(Activity activity) {
        this.mContext = activity;
        int displayWidth = af.getDisplayWidth(this.mContext);
        int displayHeight = af.getDisplayHeight(this.mContext);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.bxk = new FrameLayout.LayoutParams((displayWidth - af.dip2px(this.mContext, 10.0f)) / 4, (displayWidth - af.dip2px(this.mContext, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.bxj = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.bxi.size() > 0) {
            this.bxi.clear();
        }
        this.bxi.addAll(arrayList);
        d.m(this.bxi);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.bxi.size() + 1 : this.bxi.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.bxi.get(i - 1);
        }
        return this.bxi.get(i);
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
        C0254a c0254a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            ag(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0254a c0254a2 = new C0254a(view);
            view.setTag(c0254a2);
            c0254a = c0254a2;
        } else {
            c0254a = (C0254a) view.getTag();
        }
        a(c0254a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0254a);
            a(mediaModel, c0254a, i);
            b(mediaModel, c0254a, i);
            return view;
        }
        return view;
    }

    private void ag(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.bxk);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.bxv, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.UO();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.UQ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UO() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.mMaxSelected) {
            d.iQ(d.mMode);
        } else {
            ci(this.mContext);
        }
    }

    private void ci(Context context) {
        com.baidu.swan.apps.af.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.af.b
            public void fl(String str) {
                a.this.UP();
            }

            @Override // com.baidu.swan.apps.af.b
            public void q(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UP() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.mContext, d.bxY, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void r(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.bwz);
                bundle.putString("swanAppId", d.bxY);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.UW());
                bundle.putString("swanTmpPath", d.bya);
                d.c(a.this.mContext, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void iM(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UQ() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.mMaxSelected) {
            d.iQ(d.mMode);
        } else if (ac.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            cj(this.mContext);
        }
    }

    private void cj(Context context) {
        com.baidu.swan.apps.af.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.af.b
            public void fl(String str) {
                a.this.UR();
            }

            @Override // com.baidu.swan.apps.af.b
            public void q(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UR() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.mContext, d.bxY, d.bxZ, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void r(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.s(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.bwz);
                bundle.putString("swanAppId", d.bxY);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.UW());
                bundle.putString("swanTmpPath", d.bya);
                d.c(a.this.mContext, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void iM(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0254a c0254a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0254a.bxs.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0254a.bxr.setVisibility(0);
            c0254a.bxr.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0254a.bxq.setVisibility(0);
        } else {
            c0254a.bxq.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.bxW) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0254a.bxu.setText(this.mContext.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0254a.rightBottomTipBg.setVisibility(8);
                }
            } else {
                c0254a.bxu.setText(this.mContext.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0254a.rightBottomTipBg.setVisibility(8);
        }
        c0254a.selectView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0254a);
            }
        });
        c0254a.bxp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0254a c0254a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0254a.rightBottomTipBg.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0254a.rightBottomTipBg.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0254a.rightBottomTipBg.setLayoutParams(layoutParams);
            c0254a.bxu.setText(af(videoModel.getDuration()));
            c0254a.bxp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iN(videoModel.getPath()) && !a.this.ag(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0254a c0254a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.mMaxSelected) {
                d.iQ(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.UX(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.q(this.mContext, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0254a.bxs.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0254a.bxr.setVisibility(0);
                c0254a.bxr.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0254a.bxt.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0185a.swanapp_album_checkshake));
                if (this.bxj != null) {
                    this.bxj.selectChanged(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0254a.bxs.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0254a.bxr.setVisibility(8);
        if (this.bxj != null) {
            this.bxj.selectChanged(selectedCount);
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
            bundle.putBoolean("compressed", d.bwz);
            bundle.putString("swanAppId", d.bxY);
            bundle.putString("mode", d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.mContext, bundle);
        }
    }

    private void a(C0254a c0254a, View view) {
        Resources resources = this.mContext.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0254a.bxp.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0254a.bxr.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0254a.rightBottomTipBg.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0254a.bxu.setTextColor(resources.getColor(a.c.aiapps_white));
        c0254a.bxq.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0254a.bxp.setLayoutParams(this.bxk);
        c0254a.bxq.setLayoutParams(this.bxk);
        c0254a.bxq.setVisibility(8);
        c0254a.bxr.setVisibility(8);
        c0254a.selectView.setVisibility(8);
        c0254a.rightBottomTipBg.setVisibility(8);
        c0254a.selectView.setVisibility(0);
        c0254a.bxs.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0254a.rightBottomTipBg.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0254a.rightBottomTipBg.getLayoutParams();
        layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0254a.rightBottomTipBg.setLayoutParams(layoutParams);
    }

    private void a(String str, C0254a c0254a) {
        ImageRequestBuilder X = ImageRequestBuilder.X(Uri.fromFile(new File(str)));
        X.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        X.vg(true);
        X.a(com.facebook.imagepipeline.common.b.dlR().uY(true).dlZ());
        c0254a.bxp.setController(com.facebook.drawee.a.a.c.djg().be(X.dpZ()).uR(false).c(c0254a.bxp.getController()).djX());
    }

    private String af(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 % 60));
        if (j3 == 0) {
            return this.mContext.getString(a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.mContext.getString(a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j3)), format, format2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iN(String str) {
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
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_format)).showToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ag(long j) {
        if (j < 3000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_duration_min)).showToast();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_duration_max)).showToast();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0254a {
        private SimpleDraweeView bxp;
        private ImageView bxq;
        private TextView bxr;
        private ImageView bxs;
        private View bxt;
        private TextView bxu;
        private View rightBottomTipBg;
        private View selectView;

        public C0254a(View view) {
            this.bxp = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.bxs = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.bxr = (TextView) view.findViewById(a.f.album_item_select_number);
            this.selectView = view.findViewById(a.f.album_item_selected_check);
            this.bxt = view.findViewById(a.f.album_item_select_circle_view);
            this.bxq = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.rightBottomTipBg = view.findViewById(a.f.album_item_tip_bg);
            this.bxu = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
