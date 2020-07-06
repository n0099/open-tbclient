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
import com.baidu.swan.apps.aq.ad;
import com.baidu.swan.apps.aq.ag;
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
    private Activity bdo;
    private ArrayList<MediaModel> cqf = new ArrayList<>();
    public e cqg;
    private FrameLayout.LayoutParams cqh;
    private int mItemHeight;
    private int mItemWidth;

    public a(Activity activity) {
        this.bdo = activity;
        int displayWidth = ag.getDisplayWidth(this.bdo);
        int displayHeight = ag.getDisplayHeight(this.bdo);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.cqh = new FrameLayout.LayoutParams((displayWidth - ag.dip2px(this.bdo, 10.0f)) / 4, (displayWidth - ag.dip2px(this.bdo, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.cqg = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.cqf.size() > 0) {
            this.cqf.clear();
        }
        this.cqf.addAll(arrayList);
        d.o(this.cqf);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.cqf.size() + 1 : this.cqf.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.cqf.get(i - 1);
        }
        return this.cqf.get(i);
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
        C0364a c0364a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.bdo).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            al(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.bdo).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0364a c0364a2 = new C0364a(view);
            view.setTag(c0364a2);
            c0364a = c0364a2;
        } else {
            c0364a = (C0364a) view.getTag();
        }
        a(c0364a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0364a);
            a(mediaModel, c0364a, i);
            b(mediaModel, c0364a, i);
            return view;
        }
        return view;
    }

    private void al(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.cqh);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.cqu, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.ajV();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.ajX();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajV() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cqZ) {
            d.lP(d.mMode);
        } else {
            bZ(this.bdo);
        }
    }

    private void bZ(Context context) {
        com.baidu.swan.apps.ad.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ad.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.ad.b
            public void hg(String str) {
                a.this.ajW();
            }

            @Override // com.baidu.swan.apps.ad.b
            public void O(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajW() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.bdo, d.cra, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void x(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.cpl);
                bundle.putString("swanAppId", d.cra);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.akd());
                bundle.putString("swanTmpPath", d.crd);
                d.c(a.this.bdo, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void lL(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajX() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cqZ) {
            d.lP(d.mMode);
        } else if (ad.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bdo.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            ca(this.bdo);
        }
    }

    private void ca(Context context) {
        com.baidu.swan.apps.ad.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ad.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.ad.b
            public void hg(String str) {
                a.this.ajY();
            }

            @Override // com.baidu.swan.apps.ad.b
            public void O(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajY() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.bdo, d.cra, d.crb, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void x(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.y(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.cpl);
                bundle.putString("swanAppId", d.cra);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.akd());
                bundle.putString("swanTmpPath", d.crd);
                d.c(a.this.bdo, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void lL(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0364a c0364a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0364a.cqp.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0364a.cqo.setVisibility(0);
            c0364a.cqo.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0364a.cqn.setVisibility(0);
        } else {
            c0364a.cqn.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.cqX) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0364a.cqs.setText(this.bdo.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0364a.cqt.setVisibility(8);
                }
            } else {
                c0364a.cqs.setText(this.bdo.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0364a.cqt.setVisibility(8);
        }
        c0364a.cqr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0364a);
            }
        });
        c0364a.cqm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0364a c0364a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0364a.cqt.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0364a.cqt.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.bdo.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.bdo.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.bdo.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0364a.cqt.setLayoutParams(layoutParams);
            c0364a.cqs.setText(aX(videoModel.getDuration()));
            c0364a.cqm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lM(videoModel.getPath()) && !a.this.aY(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0364a c0364a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.cqZ) {
                d.lP(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.ake(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.k(this.bdo, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0364a.cqp.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0364a.cqo.setVisibility(0);
                c0364a.cqo.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0364a.cqq.startAnimation(AnimationUtils.loadAnimation(this.bdo, a.C0287a.swanapp_album_checkshake));
                if (this.cqg != null) {
                    this.cqg.fU(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0364a.cqp.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0364a.cqo.setVisibility(8);
        if (this.cqg != null) {
            this.cqg.fU(selectedCount);
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
            bundle.putBoolean("compressed", d.cpl);
            bundle.putString("swanAppId", d.cra);
            bundle.putString("mode", d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.bdo, bundle);
        }
    }

    private void a(C0364a c0364a, View view) {
        Resources resources = this.bdo.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0364a.cqm.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0364a.cqo.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0364a.cqt.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0364a.cqs.setTextColor(resources.getColor(a.c.aiapps_white));
        c0364a.cqn.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0364a.cqm.setLayoutParams(this.cqh);
        c0364a.cqn.setLayoutParams(this.cqh);
        c0364a.cqn.setVisibility(8);
        c0364a.cqo.setVisibility(8);
        c0364a.cqr.setVisibility(8);
        c0364a.cqt.setVisibility(8);
        c0364a.cqr.setVisibility(0);
        c0364a.cqp.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0364a.cqt.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0364a.cqt.getLayoutParams();
        layoutParams.width = this.bdo.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.bdo.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0364a.cqt.setLayoutParams(layoutParams);
    }

    private void a(String str, C0364a c0364a) {
        ImageRequestBuilder ac = ImageRequestBuilder.ac(Uri.fromFile(new File(str)));
        ac.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        ac.wM(true);
        ac.a(com.facebook.imagepipeline.common.b.dCU().wE(true).dDc());
        c0364a.cqm.setController(com.facebook.drawee.a.a.c.dAa().bc(ac.dHf()).wy(false).c(c0364a.cqm.getController()).dAR());
    }

    private String aX(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 % 60));
        if (j3 == 0) {
            return this.bdo.getString(a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.bdo.getString(a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j3)), format, format2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lM(String str) {
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
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bdo.getString(a.h.swanapp_album_video_format)).showToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aY(long j) {
        if (j < 3000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bdo.getString(a.h.swanapp_album_video_duration_min)).showToast();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bdo.getString(a.h.swanapp_album_video_duration_max)).showToast();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0364a {
        private SimpleDraweeView cqm;
        private ImageView cqn;
        private TextView cqo;
        private ImageView cqp;
        private View cqq;
        private View cqr;
        private TextView cqs;
        private View cqt;

        public C0364a(View view) {
            this.cqm = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.cqp = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.cqo = (TextView) view.findViewById(a.f.album_item_select_number);
            this.cqr = view.findViewById(a.f.album_item_selected_check);
            this.cqq = view.findViewById(a.f.album_item_select_circle_view);
            this.cqn = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.cqt = view.findViewById(a.f.album_item_tip_bg);
            this.cqs = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
