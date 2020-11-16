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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private Activity bMo;
    private ArrayList<MediaModel> daQ = new ArrayList<>();
    public e daR;
    private int mItemHeight;
    private int mItemWidth;
    private FrameLayout.LayoutParams mLayoutParams;

    public a(Activity activity) {
        this.bMo = activity;
        int displayWidth = ah.getDisplayWidth(this.bMo);
        int displayHeight = ah.getDisplayHeight(this.bMo);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.mLayoutParams = new FrameLayout.LayoutParams((displayWidth - ah.dip2px(this.bMo, 10.0f)) / 4, (displayWidth - ah.dip2px(this.bMo, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.daR = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.daQ.size() > 0) {
            this.daQ.clear();
        }
        this.daQ.addAll(arrayList);
        d.t(this.daQ);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.daQ.size() + 1 : this.daQ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.daQ.get(i - 1);
        }
        return this.daQ.get(i);
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
        C0451a c0451a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.bMo).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            ax(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.bMo).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0451a c0451a2 = new C0451a(view);
            view.setTag(c0451a2);
            c0451a = c0451a2;
        } else {
            c0451a = (C0451a) view.getTag();
        }
        a(c0451a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0451a);
            a(mediaModel, c0451a, i);
            b(mediaModel, c0451a, i);
            return view;
        }
        return view;
    }

    private void ax(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.mLayoutParams);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.cVo, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.aAf();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aAh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAf() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.dbI) {
            d.pW(d.mMode);
        } else {
            cn(this.bMo);
        }
    }

    private void cn(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.ab.b
            public void kn(String str) {
                a.this.aAg();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void af(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAg() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.bMo, d.dbJ, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void E(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.cZW);
                bundle.putString("swanAppId", d.dbJ);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aAn());
                bundle.putString("swanTmpPath", d.dbL);
                d.c(a.this.bMo, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void pS(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAh() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.dbI) {
            d.pW(d.mMode);
        } else if (af.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bMo.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            co(this.bMo);
        }
    }

    private void co(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.ab.b
            public void kn(String str) {
                a.this.aAi();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void af(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAi() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.bMo, d.dbJ, d.dbK, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void E(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.F(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.cZW);
                bundle.putString("swanAppId", d.dbJ);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aAn());
                bundle.putString("swanTmpPath", d.dbL);
                d.c(a.this.bMo, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void pS(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0451a c0451a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0451a.daZ.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0451a.daY.setVisibility(0);
            c0451a.daY.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0451a.daX.setVisibility(0);
        } else {
            c0451a.daX.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.dbG) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0451a.dbc.setText(this.bMo.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0451a.dbd.setVisibility(8);
                }
            } else {
                c0451a.dbc.setText(this.bMo.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0451a.dbd.setVisibility(8);
        }
        c0451a.dbb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0451a);
            }
        });
        c0451a.daW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0451a c0451a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0451a.dbd.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0451a.dbd.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.bMo.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.bMo.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.bMo.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0451a.dbd.setLayoutParams(layoutParams);
            c0451a.dbc.setText(bN(videoModel.getDuration()));
            c0451a.daW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.pT(videoModel.getPath()) && !a.this.bO(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0451a c0451a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.dbI) {
                d.pW(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.aAo(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.k(this.bMo, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0451a.daZ.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0451a.daY.setVisibility(0);
                c0451a.daY.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0451a.dba.startAnimation(AnimationUtils.loadAnimation(this.bMo, a.C0367a.swanapp_album_checkshake));
                if (this.daR != null) {
                    this.daR.jg(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0451a.daZ.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0451a.daY.setVisibility(8);
        if (this.daR != null) {
            this.daR.jg(selectedCount);
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
            bundle.putBoolean("compressed", d.cZW);
            bundle.putString("swanAppId", d.dbJ);
            bundle.putString(UbcStatConstant.KEY_CONTENT_EXT_MODE, d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.bMo, bundle);
        }
    }

    private void a(C0451a c0451a, View view) {
        Resources resources = this.bMo.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0451a.daW.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0451a.daY.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0451a.dbd.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0451a.dbc.setTextColor(resources.getColor(a.c.aiapps_white));
        c0451a.daX.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0451a.daW.setLayoutParams(this.mLayoutParams);
        c0451a.daX.setLayoutParams(this.mLayoutParams);
        c0451a.daX.setVisibility(8);
        c0451a.daY.setVisibility(8);
        c0451a.dbb.setVisibility(8);
        c0451a.dbd.setVisibility(8);
        c0451a.dbb.setVisibility(0);
        c0451a.daZ.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0451a.dbd.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0451a.dbd.getLayoutParams();
        layoutParams.width = this.bMo.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.bMo.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0451a.dbd.setLayoutParams(layoutParams);
    }

    private void a(String str, C0451a c0451a) {
        ImageRequestBuilder ae = ImageRequestBuilder.ae(Uri.fromFile(new File(str)));
        ae.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        ae.AA(true);
        ae.a(com.facebook.imagepipeline.common.b.enK().As(true).enS());
        c0451a.daW.setController(com.facebook.drawee.a.a.c.ekQ().bo(ae.erW()).Am(false).c(c0451a.daW.getController()).elH());
    }

    private String bN(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 % 60));
        if (j3 == 0) {
            return this.bMo.getString(a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.bMo.getString(a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j3)), format, format2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pT(String str) {
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
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bMo.getString(a.h.swanapp_album_video_format)).showToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bO(long j) {
        if (j < IMConnection.RETRY_DELAY_TIMES) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bMo.getString(a.h.swanapp_album_video_duration_min)).showToast();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bMo.getString(a.h.swanapp_album_video_duration_max)).showToast();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0451a {
        private SimpleDraweeView daW;
        private ImageView daX;
        private TextView daY;
        private ImageView daZ;
        private View dba;
        private View dbb;
        private TextView dbc;
        private View dbd;

        public C0451a(View view) {
            this.daW = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.daZ = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.daY = (TextView) view.findViewById(a.f.album_item_select_number);
            this.dbb = view.findViewById(a.f.album_item_selected_check);
            this.dba = view.findViewById(a.f.album_item_select_circle_view);
            this.daX = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.dbd = view.findViewById(a.f.album_item_tip_bg);
            this.dbc = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
