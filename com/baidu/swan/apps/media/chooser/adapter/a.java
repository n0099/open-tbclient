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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public e cAa;
    private Activity czY;
    private ArrayList<MediaModel> czZ = new ArrayList<>();
    private int mItemHeight;
    private int mItemWidth;
    private FrameLayout.LayoutParams mLayoutParams;

    public a(Activity activity) {
        this.czY = activity;
        int displayWidth = ah.getDisplayWidth(this.czY);
        int displayHeight = ah.getDisplayHeight(this.czY);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.mLayoutParams = new FrameLayout.LayoutParams((displayWidth - ah.dip2px(this.czY, 10.0f)) / 4, (displayWidth - ah.dip2px(this.czY, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.cAa = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.czZ.size() > 0) {
            this.czZ.clear();
        }
        this.czZ.addAll(arrayList);
        d.t(this.czZ);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.czZ.size() + 1 : this.czZ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.czZ.get(i - 1);
        }
        return this.czZ.get(i);
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
        C0415a c0415a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.czY).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            ap(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.czY).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0415a c0415a2 = new C0415a(view);
            view.setTag(c0415a2);
            c0415a = c0415a2;
        } else {
            c0415a = (C0415a) view.getTag();
        }
        a(c0415a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0415a);
            a(mediaModel, c0415a, i);
            b(mediaModel, c0415a, i);
            return view;
        }
        return view;
    }

    private void ap(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.mLayoutParams);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.cuy, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.asZ();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.atb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asZ() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cAR) {
            d.op(d.mMode);
        } else {
            ci(this.czY);
        }
    }

    private void ci(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.ab.b
            public void iF(String str) {
                a.this.ata();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void N(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ata() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.czY, d.cAS, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void B(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.czg);
                bundle.putString("swanAppId", d.cAS);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.ath());
                bundle.putString("swanTmpPath", d.cAU);
                d.c(a.this.czY, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void ok(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atb() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cAR) {
            d.op(d.mMode);
        } else if (af.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.czY.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            cj(this.czY);
        }
    }

    private void cj(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.ab.b
            public void iF(String str) {
                a.this.atc();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void N(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atc() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.czY, d.cAS, d.cAT, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void B(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.C(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.czg);
                bundle.putString("swanAppId", d.cAS);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.ath());
                bundle.putString("swanTmpPath", d.cAU);
                d.c(a.this.czY, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void ok(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0415a c0415a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0415a.cAi.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0415a.cAh.setVisibility(0);
            c0415a.cAh.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0415a.cAg.setVisibility(0);
        } else {
            c0415a.cAg.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.cAP) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0415a.cAl.setText(this.czY.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0415a.cAm.setVisibility(8);
                }
            } else {
                c0415a.cAl.setText(this.czY.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0415a.cAm.setVisibility(8);
        }
        c0415a.cAk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0415a);
            }
        });
        c0415a.cAf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0415a c0415a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0415a.cAm.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0415a.cAm.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.czY.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.czY.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.czY.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0415a.cAm.setLayoutParams(layoutParams);
            c0415a.cAl.setText(bg(videoModel.getDuration()));
            c0415a.cAf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.ol(videoModel.getPath()) && !a.this.bh(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0415a c0415a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.cAR) {
                d.op(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.ati(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.k(this.czY, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0415a.cAi.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0415a.cAh.setVisibility(0);
                c0415a.cAh.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0415a.cAj.startAnimation(AnimationUtils.loadAnimation(this.czY, a.C0331a.swanapp_album_checkshake));
                if (this.cAa != null) {
                    this.cAa.ii(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0415a.cAi.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0415a.cAh.setVisibility(8);
        if (this.cAa != null) {
            this.cAa.ii(selectedCount);
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
            bundle.putBoolean("compressed", d.czg);
            bundle.putString("swanAppId", d.cAS);
            bundle.putString("mode", d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.czY, bundle);
        }
    }

    private void a(C0415a c0415a, View view) {
        Resources resources = this.czY.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0415a.cAf.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0415a.cAh.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0415a.cAm.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0415a.cAl.setTextColor(resources.getColor(a.c.aiapps_white));
        c0415a.cAg.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0415a.cAf.setLayoutParams(this.mLayoutParams);
        c0415a.cAg.setLayoutParams(this.mLayoutParams);
        c0415a.cAg.setVisibility(8);
        c0415a.cAh.setVisibility(8);
        c0415a.cAk.setVisibility(8);
        c0415a.cAm.setVisibility(8);
        c0415a.cAk.setVisibility(0);
        c0415a.cAi.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0415a.cAm.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0415a.cAm.getLayoutParams();
        layoutParams.width = this.czY.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.czY.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0415a.cAm.setLayoutParams(layoutParams);
    }

    private void a(String str, C0415a c0415a) {
        ImageRequestBuilder ab = ImageRequestBuilder.ab(Uri.fromFile(new File(str)));
        ab.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        ab.yi(true);
        ab.a(com.facebook.imagepipeline.common.b.dSg().ya(true).dSo());
        c0415a.cAf.setController(com.facebook.drawee.a.a.c.dPn().be(ab.dWr()).xU(false).c(c0415a.cAf.getController()).dQe());
    }

    private String bg(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 % 60));
        if (j3 == 0) {
            return this.czY.getString(a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.czY.getString(a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j3)), format, format2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ol(String str) {
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
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.czY.getString(a.h.swanapp_album_video_format)).showToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bh(long j) {
        if (j < IMConnection.RETRY_DELAY_TIMES) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.czY.getString(a.h.swanapp_album_video_duration_min)).showToast();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.czY.getString(a.h.swanapp_album_video_duration_max)).showToast();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0415a {
        private SimpleDraweeView cAf;
        private ImageView cAg;
        private TextView cAh;
        private ImageView cAi;
        private View cAj;
        private View cAk;
        private TextView cAl;
        private View cAm;

        public C0415a(View view) {
            this.cAf = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.cAi = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.cAh = (TextView) view.findViewById(a.f.album_item_select_number);
            this.cAk = view.findViewById(a.f.album_item_selected_check);
            this.cAj = view.findViewById(a.f.album_item_select_circle_view);
            this.cAg = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.cAm = view.findViewById(a.f.album_item_tip_bg);
            this.cAl = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
