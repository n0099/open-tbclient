package com.baidu.swan.apps.media.chooser.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c extends RecyclerView.Adapter<a> {
    private MediaModel cAK;
    private int cAL;
    private ArrayList<MediaModel> cAd;

    public c(Context context) {
        this.cAL = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> ate() {
        return this.cAd;
    }

    public void s(ArrayList<MediaModel> arrayList) {
        this.cAd = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.cAK = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.cAd != null) {
            MediaModel mediaModel2 = this.cAK;
            this.cAK = mediaModel;
            int size = this.cAd.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.cAd.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.cAd.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                    i = i3;
                }
                if (i2 >= 2) {
                    break;
                }
            }
        }
        return i;
    }

    public MediaModel in(int i) {
        if (this.cAd == null || i < 0 || i >= this.cAd.size()) {
            return null;
        }
        return this.cAd.get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: b */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(a.g.swanapp_thumbnail_drag_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (this.cAd != null) {
            MediaModel mediaModel = this.cAd.get(i);
            aVar.cAM.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.cAN.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.cAO.setVisibility(mediaModel.equals(this.cAK) ? 0 : 8);
            ImageRequestBuilder ab = ImageRequestBuilder.ab(Uri.fromFile(new File(mediaModel.getPath())));
            ab.c(new d(this.cAL, this.cAL));
            ab.yk(true);
            aVar.cAM.setController(com.facebook.drawee.a.a.c.dPw().c(aVar.cAM.getController()).xW(false).be(ab.dWA()).dQn());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cAd == null) {
            return 0;
        }
        return this.cAd.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView cAM;
        private View cAN;
        private View cAO;

        a(View view) {
            super(view);
            this.cAM = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.cAN = view.findViewById(a.f.album_thumbnail_video);
            this.cAO = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
