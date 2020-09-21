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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private Activity byQ;
    private ArrayList<MediaModel> cCd = new ArrayList<>();
    public e cCe;
    private int mItemHeight;
    private int mItemWidth;
    private FrameLayout.LayoutParams mLayoutParams;

    public a(Activity activity) {
        this.byQ = activity;
        int displayWidth = ah.getDisplayWidth(this.byQ);
        int displayHeight = ah.getDisplayHeight(this.byQ);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.mLayoutParams = new FrameLayout.LayoutParams((displayWidth - ah.dip2px(this.byQ, 10.0f)) / 4, (displayWidth - ah.dip2px(this.byQ, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.cCe = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.cCd.size() > 0) {
            this.cCd.clear();
        }
        this.cCd.addAll(arrayList);
        d.t(this.cCd);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.cCd.size() + 1 : this.cCd.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.cCd.get(i - 1);
        }
        return this.cCd.get(i);
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
        C0410a c0410a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.byQ).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            ar(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.byQ).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0410a c0410a2 = new C0410a(view);
            view.setTag(c0410a2);
            c0410a = c0410a2;
        } else {
            c0410a = (C0410a) view.getTag();
        }
        a(c0410a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0410a);
            a(mediaModel, c0410a, i);
            b(mediaModel, c0410a, i);
            return view;
        }
        return view;
    }

    private void ar(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.mLayoutParams);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.cwD, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.atI();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.atK();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atI() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cCV) {
            d.oJ(d.mMode);
        } else {
            ch(this.byQ);
        }
    }

    private void ch(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.ab.b
            public void iZ(String str) {
                a.this.atJ();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void O(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atJ() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.byQ, d.cCW, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void B(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.cBl);
                bundle.putString("swanAppId", d.cCW);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.atQ());
                bundle.putString("swanTmpPath", d.cCY);
                d.c(a.this.byQ, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void oF(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atK() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cCV) {
            d.oJ(d.mMode);
        } else if (af.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.byQ.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            ci(this.byQ);
        }
    }

    private void ci(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.ab.b
            public void iZ(String str) {
                a.this.atL();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void O(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atL() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.byQ, d.cCW, d.cCX, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void B(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.C(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.cBl);
                bundle.putString("swanAppId", d.cCW);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.atQ());
                bundle.putString("swanTmpPath", d.cCY);
                d.c(a.this.byQ, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void oF(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0410a c0410a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0410a.cCm.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0410a.cCl.setVisibility(0);
            c0410a.cCl.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0410a.cCk.setVisibility(0);
        } else {
            c0410a.cCk.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.cCT) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0410a.cCp.setText(this.byQ.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0410a.cCq.setVisibility(8);
                }
            } else {
                c0410a.cCp.setText(this.byQ.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0410a.cCq.setVisibility(8);
        }
        c0410a.cCo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0410a);
            }
        });
        c0410a.cCj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0410a c0410a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0410a.cCq.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0410a.cCq.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.byQ.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.byQ.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.byQ.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0410a.cCq.setLayoutParams(layoutParams);
            c0410a.cCp.setText(bh(videoModel.getDuration()));
            c0410a.cCj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.oG(videoModel.getPath()) && !a.this.bi(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0410a c0410a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.cCV) {
                d.oJ(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.atR(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.k(this.byQ, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0410a.cCm.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0410a.cCl.setVisibility(0);
                c0410a.cCl.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0410a.cCn.startAnimation(AnimationUtils.loadAnimation(this.byQ, a.C0326a.swanapp_album_checkshake));
                if (this.cCe != null) {
                    this.cCe.is(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0410a.cCm.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0410a.cCl.setVisibility(8);
        if (this.cCe != null) {
            this.cCe.is(selectedCount);
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
            bundle.putBoolean("compressed", d.cBl);
            bundle.putString("swanAppId", d.cCW);
            bundle.putString("mode", d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.byQ, bundle);
        }
    }

    private void a(C0410a c0410a, View view) {
        Resources resources = this.byQ.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0410a.cCj.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0410a.cCl.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0410a.cCq.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0410a.cCp.setTextColor(resources.getColor(a.c.aiapps_white));
        c0410a.cCk.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0410a.cCj.setLayoutParams(this.mLayoutParams);
        c0410a.cCk.setLayoutParams(this.mLayoutParams);
        c0410a.cCk.setVisibility(8);
        c0410a.cCl.setVisibility(8);
        c0410a.cCo.setVisibility(8);
        c0410a.cCq.setVisibility(8);
        c0410a.cCo.setVisibility(0);
        c0410a.cCm.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0410a.cCq.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0410a.cCq.getLayoutParams();
        layoutParams.width = this.byQ.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.byQ.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0410a.cCq.setLayoutParams(layoutParams);
    }

    private void a(String str, C0410a c0410a) {
        ImageRequestBuilder ad = ImageRequestBuilder.ad(Uri.fromFile(new File(str)));
        ad.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        ad.yt(true);
        ad.a(com.facebook.imagepipeline.common.b.dWn().yl(true).dWv());
        c0410a.cCj.setController(com.facebook.drawee.a.a.c.dTu().bg(ad.eay()).yf(false).c(c0410a.cCj.getController()).dUl());
    }

    private String bh(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 % 60));
        if (j3 == 0) {
            return this.byQ.getString(a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.byQ.getString(a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j3)), format, format2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oG(String str) {
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
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.byQ.getString(a.h.swanapp_album_video_format)).showToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bi(long j) {
        if (j < IMConnection.RETRY_DELAY_TIMES) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.byQ.getString(a.h.swanapp_album_video_duration_min)).showToast();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.byQ.getString(a.h.swanapp_album_video_duration_max)).showToast();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0410a {
        private SimpleDraweeView cCj;
        private ImageView cCk;
        private TextView cCl;
        private ImageView cCm;
        private View cCn;
        private View cCo;
        private TextView cCp;
        private View cCq;

        public C0410a(View view) {
            this.cCj = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.cCm = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.cCl = (TextView) view.findViewById(a.f.album_item_select_number);
            this.cCo = view.findViewById(a.f.album_item_selected_check);
            this.cCn = view.findViewById(a.f.album_item_select_circle_view);
            this.cCk = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.cCq = view.findViewById(a.f.album_item_tip_bg);
            this.cCp = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
