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
import com.baidu.swan.apps.aq.af;
import com.baidu.swan.apps.aq.ai;
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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private Activity bdG;
    private ArrayList<MediaModel> csj = new ArrayList<>();
    public e csk;
    private FrameLayout.LayoutParams csl;
    private int mItemHeight;
    private int mItemWidth;

    public a(Activity activity) {
        this.bdG = activity;
        int displayWidth = ai.getDisplayWidth(this.bdG);
        int displayHeight = ai.getDisplayHeight(this.bdG);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.csl = new FrameLayout.LayoutParams((displayWidth - ai.dip2px(this.bdG, 10.0f)) / 4, (displayWidth - ai.dip2px(this.bdG, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.csk = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.csj.size() > 0) {
            this.csj.clear();
        }
        this.csj.addAll(arrayList);
        d.o(this.csj);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.csj.size() + 1 : this.csj.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.csj.get(i - 1);
        }
        return this.csj.get(i);
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
        C0366a c0366a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.bdG).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            ao(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.bdG).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0366a c0366a2 = new C0366a(view);
            view.setTag(c0366a2);
            c0366a = c0366a2;
        } else {
            c0366a = (C0366a) view.getTag();
        }
        a(c0366a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0366a);
            a(mediaModel, c0366a, i);
            b(mediaModel, c0366a, i);
            return view;
        }
        return view;
    }

    private void ao(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.csl);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.csy, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.all();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aln();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void all() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.ctd) {
            d.mq(d.mMode);
        } else {
            cc(this.bdG);
        }
    }

    private void cc(Context context) {
        com.baidu.swan.apps.ac.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ac.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.ac.b
            public void hm(String str) {
                a.this.alm();
            }

            @Override // com.baidu.swan.apps.ac.b
            public void O(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alm() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.bdG, d.cte, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void A(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.crr);
                bundle.putString("swanAppId", d.cte);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.alt());
                bundle.putString("swanTmpPath", d.ctg);
                d.c(a.this.bdG, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void mm(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aln() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.ctd) {
            d.mq(d.mMode);
        } else if (af.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bdG.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            cd(this.bdG);
        }
    }

    private void cd(Context context) {
        com.baidu.swan.apps.ac.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ac.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.ac.b
            public void hm(String str) {
                a.this.alo();
            }

            @Override // com.baidu.swan.apps.ac.b
            public void O(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alo() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.bdG, d.cte, d.ctf, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void A(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.B(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.crr);
                bundle.putString("swanAppId", d.cte);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.alt());
                bundle.putString("swanTmpPath", d.ctg);
                d.c(a.this.bdG, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void mm(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0366a c0366a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0366a.cst.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0366a.css.setVisibility(0);
            c0366a.css.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0366a.csr.setVisibility(0);
        } else {
            c0366a.csr.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.ctb) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0366a.csw.setText(this.bdG.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0366a.csx.setVisibility(8);
                }
            } else {
                c0366a.csw.setText(this.bdG.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0366a.csx.setVisibility(8);
        }
        c0366a.csv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0366a);
            }
        });
        c0366a.csq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0366a c0366a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0366a.csx.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0366a.csx.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.bdG.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.bdG.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.bdG.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0366a.csx.setLayoutParams(layoutParams);
            c0366a.csw.setText(bb(videoModel.getDuration()));
            c0366a.csq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.mn(videoModel.getPath()) && !a.this.bc(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0366a c0366a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.ctd) {
                d.mq(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.alu(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.k(this.bdG, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0366a.cst.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0366a.css.setVisibility(0);
                c0366a.css.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0366a.csu.startAnimation(AnimationUtils.loadAnimation(this.bdG, a.C0290a.swanapp_album_checkshake));
                if (this.csk != null) {
                    this.csk.ge(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0366a.cst.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0366a.css.setVisibility(8);
        if (this.csk != null) {
            this.csk.ge(selectedCount);
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
            bundle.putBoolean("compressed", d.crr);
            bundle.putString("swanAppId", d.cte);
            bundle.putString("mode", d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.bdG, bundle);
        }
    }

    private void a(C0366a c0366a, View view) {
        Resources resources = this.bdG.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0366a.csq.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0366a.css.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0366a.csx.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0366a.csw.setTextColor(resources.getColor(a.c.aiapps_white));
        c0366a.csr.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0366a.csq.setLayoutParams(this.csl);
        c0366a.csr.setLayoutParams(this.csl);
        c0366a.csr.setVisibility(8);
        c0366a.css.setVisibility(8);
        c0366a.csv.setVisibility(8);
        c0366a.csx.setVisibility(8);
        c0366a.csv.setVisibility(0);
        c0366a.cst.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0366a.csx.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0366a.csx.getLayoutParams();
        layoutParams.width = this.bdG.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.bdG.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0366a.csx.setLayoutParams(layoutParams);
    }

    private void a(String str, C0366a c0366a) {
        ImageRequestBuilder ab = ImageRequestBuilder.ab(Uri.fromFile(new File(str)));
        ab.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        ab.xr(true);
        ab.a(com.facebook.imagepipeline.common.b.dGg().xj(true).dGo());
        c0366a.csq.setController(com.facebook.drawee.a.a.c.dDm().bc(ab.dKr()).xd(false).c(c0366a.csq.getController()).dEd());
    }

    private String bb(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 % 60));
        if (j3 == 0) {
            return this.bdG.getString(a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.bdG.getString(a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j3)), format, format2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mn(String str) {
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
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bdG.getString(a.h.swanapp_album_video_format)).showToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bc(long j) {
        if (j < 3000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bdG.getString(a.h.swanapp_album_video_duration_min)).showToast();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bdG.getString(a.h.swanapp_album_video_duration_max)).showToast();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0366a {
        private SimpleDraweeView csq;
        private ImageView csr;
        private TextView css;
        private ImageView cst;
        private View csu;
        private View csv;
        private TextView csw;
        private View csx;

        public C0366a(View view) {
            this.csq = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.cst = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.css = (TextView) view.findViewById(a.f.album_item_select_number);
            this.csv = view.findViewById(a.f.album_item_selected_check);
            this.csu = view.findViewById(a.f.album_item_select_circle_view);
            this.csr = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.csx = view.findViewById(a.f.album_item_tip_bg);
            this.csw = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
