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
/* loaded from: classes3.dex */
public class c extends RecyclerView.Adapter<a> {
    private MediaModel cCK;
    private int cCL;
    private ArrayList<MediaModel> cCd;

    public c(Context context) {
        this.cCL = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> atN() {
        return this.cCd;
    }

    public void s(ArrayList<MediaModel> arrayList) {
        this.cCd = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.cCK = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.cCd != null) {
            MediaModel mediaModel2 = this.cCK;
            this.cCK = mediaModel;
            int size = this.cCd.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.cCd.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.cCd.get(i3))) {
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

    public MediaModel ix(int i) {
        if (this.cCd == null || i < 0 || i >= this.cCd.size()) {
            return null;
        }
        return this.cCd.get(i);
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
        if (this.cCd != null) {
            MediaModel mediaModel = this.cCd.get(i);
            aVar.cCM.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.cCN.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.cCO.setVisibility(mediaModel.equals(this.cCK) ? 0 : 8);
            ImageRequestBuilder ad = ImageRequestBuilder.ad(Uri.fromFile(new File(mediaModel.getPath())));
            ad.c(new d(this.cCL, this.cCL));
            ad.yt(true);
            aVar.cCM.setController(com.facebook.drawee.a.a.c.dTu().c(aVar.cCM.getController()).yf(false).bg(ad.eay()).dUl());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cCd == null) {
            return 0;
        }
        return this.cCd.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView cCM;
        private View cCN;
        private View cCO;

        a(View view) {
            super(view);
            this.cCM = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.cCN = view.findViewById(a.f.album_thumbnail_video);
            this.cCO = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
