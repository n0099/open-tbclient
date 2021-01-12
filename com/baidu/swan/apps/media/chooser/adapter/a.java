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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.af;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.media.chooser.b.c;
import com.baidu.swan.apps.media.chooser.b.d;
import com.baidu.swan.apps.media.chooser.listener.e;
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
    private ArrayList<MediaModel> dhT = new ArrayList<>();
    public e dhU;
    private int dhV;
    private Activity mContext;
    private int mItemWidth;
    private FrameLayout.LayoutParams mLayoutParams;

    public a(Activity activity) {
        this.mContext = activity;
        int displayWidth = ah.getDisplayWidth(this.mContext);
        int displayHeight = ah.getDisplayHeight(this.mContext);
        this.mItemWidth = displayWidth / 4;
        this.dhV = displayHeight / 4;
        this.mLayoutParams = new FrameLayout.LayoutParams((displayWidth - ah.dip2px(this.mContext, 10.0f)) / 4, (displayWidth - ah.dip2px(this.mContext, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.dhU = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.dhT.size() > 0) {
            this.dhT.clear();
        }
        this.dhT.addAll(arrayList);
        d.o(this.dhT);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.diV ? this.dhT.size() + 1 : this.dhT.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.diV) {
            if (i == 0) {
                return null;
            }
            return this.dhT.get(i - 1);
        }
        return this.dhT.get(i);
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
        return (d.diV && i == 0) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0438a c0438a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            aF(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0438a c0438a2 = new C0438a(view);
            view.setTag(c0438a2);
            c0438a = c0438a2;
        } else {
            c0438a = (C0438a) view.getTag();
        }
        a(c0438a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0438a);
            a(mediaModel, c0438a, i);
            b(mediaModel, c0438a, i);
            return view;
        }
        return view;
    }

    private void aF(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.mLayoutParams);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.dcp, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.aAN();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aAP();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAN() {
        if (com.baidu.swan.apps.media.chooser.b.e.aAW() >= d.diS) {
            d.pl(d.mMode);
        } else {
            da(this.mContext);
        }
    }

    private void da(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.ab.b
            public void jC(String str) {
                a.this.aAO();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void ai(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAO() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.mContext, d.diT, new com.baidu.swan.apps.media.chooser.listener.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void F(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.dhb);
                bundle.putString("swanAppId", d.diT);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aAV());
                bundle.putString("swanTmpPath", d.diW);
                d.c(a.this.mContext, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void ph(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAP() {
        if (com.baidu.swan.apps.media.chooser.b.e.aAW() >= d.diS) {
            d.pl(d.mMode);
        } else if (af.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getResources().getString(a.h.swanapp_album_camera_no_storage)).aHZ();
        } else {
            db(this.mContext);
        }
    }

    private void db(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.ab.b
            public void jC(String str) {
                a.this.aAQ();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void ai(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAQ() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.mContext, d.diT, d.diU, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.listener.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void F(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.G(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.dhb);
                bundle.putString("swanAppId", d.diT);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aAV());
                bundle.putString("swanTmpPath", d.diW);
                d.c(a.this.mContext, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void ph(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0438a c0438a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0438a.die.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0438a.dic.setVisibility(0);
            c0438a.dic.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0438a.dib.setVisibility(0);
        } else {
            c0438a.dib.setVisibility(8);
        }
        if (c.diQ) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.pm(mediaModel.getPath())) {
                    c0438a.dih.setText(this.mContext.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0438a.dii.setVisibility(8);
                }
            } else {
                c0438a.dih.setText(this.mContext.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0438a.dii.setVisibility(8);
        }
        c0438a.dig.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0438a);
            }
        });
        c0438a.dia.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0438a c0438a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0438a.dii.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0438a.dii.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0438a.dii.setLayoutParams(layoutParams);
            c0438a.dih.setText(cn(videoModel.getDuration()));
            c0438a.dia.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.pi(videoModel.getPath()) && !a.this.co(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0438a c0438a) {
        int aAW = com.baidu.swan.apps.media.chooser.b.e.aAW();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (aAW >= d.diS) {
                d.pl(d.mMode);
                return;
            } else if (aAW > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.aAX(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.swanapp_album_select_single).aHZ();
                return;
            } else {
                c0438a.die.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0438a.dic.setVisibility(0);
                c0438a.dic.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0438a.dif.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0355a.swanapp_album_checkshake));
                if (this.dhU != null) {
                    this.dhU.hT(aAW);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0438a.die.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0438a.dic.setVisibility(8);
        if (this.dhU != null) {
            this.dhU.hT(aAW);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, int i) {
        if (!d.a(d.mMode, mediaModel)) {
            if (d.diV) {
                i--;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.dhb);
            bundle.putString("swanAppId", d.diT);
            bundle.putString(UbcStatConstant.KEY_CONTENT_EXT_MODE, d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.mContext, bundle);
        }
    }

    private void a(C0438a c0438a, View view) {
        Resources resources = this.mContext.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0438a.dia.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0438a.dic.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0438a.dii.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0438a.dih.setTextColor(resources.getColor(a.c.aiapps_white));
        c0438a.dib.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0438a.dia.setLayoutParams(this.mLayoutParams);
        c0438a.dib.setLayoutParams(this.mLayoutParams);
        c0438a.dib.setVisibility(8);
        c0438a.dic.setVisibility(8);
        c0438a.dig.setVisibility(8);
        c0438a.dii.setVisibility(8);
        c0438a.dig.setVisibility(0);
        c0438a.die.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0438a.dii.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0438a.dii.getLayoutParams();
        layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0438a.dii.setLayoutParams(layoutParams);
    }

    private void a(String str, C0438a c0438a) {
        ImageRequestBuilder ag = ImageRequestBuilder.ag(Uri.fromFile(new File(str)));
        ag.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.dhV / 2.0f)));
        ag.Bf(true);
        ag.a(com.facebook.imagepipeline.common.b.etL().AZ(true).etT());
        c0438a.dia.setController(com.facebook.drawee.a.a.c.eqV().bo(ag.exQ()).AT(false).c(c0438a.dia.getController()).erN());
    }

    private String cn(long j) {
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
    public boolean pi(String str) {
        String str2 = "";
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            str2 = mediaMetadataRetriever.extractMetadata(12);
        } catch (Exception e) {
            if (c.DEBUG) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str2) && str2.startsWith("video/")) {
            return TextUtils.equals("video/mp4", str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals("video/webm", str2) || TextUtils.equals("video/mkv", str2);
        }
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_format)).aHZ();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean co(long j) {
        if (j < IMConnection.RETRY_DELAY_TIMES) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_duration_min)).aHZ();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_duration_max)).aHZ();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0438a {
        private SimpleDraweeView dia;
        private ImageView dib;
        private TextView dic;
        private ImageView die;
        private View dif;
        private View dig;
        private TextView dih;
        private View dii;

        public C0438a(View view) {
            this.dia = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.die = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.dic = (TextView) view.findViewById(a.f.album_item_select_number);
            this.dig = view.findViewById(a.f.album_item_selected_check);
            this.dif = view.findViewById(a.f.album_item_select_circle_view);
            this.dib = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.dii = view.findViewById(a.f.album_item_tip_bg);
            this.dih = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
