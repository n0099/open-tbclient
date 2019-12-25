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
/* loaded from: classes9.dex */
public class c extends RecyclerView.Adapter<a> {
    private MediaModel bxN;
    private int bxO;
    private ArrayList<MediaModel> bxi;

    public c(Context context) {
        this.bxO = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> UT() {
        return this.bxi;
    }

    public void l(ArrayList<MediaModel> arrayList) {
        this.bxi = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.bxN = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.bxi != null) {
            MediaModel mediaModel2 = this.bxN;
            this.bxN = mediaModel;
            int size = this.bxi.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.bxi.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.bxi.get(i3))) {
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

    public MediaModel fa(int i) {
        if (this.bxi == null || i < 0 || i >= this.bxi.size()) {
            return null;
        }
        return this.bxi.get(i);
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
        if (this.bxi != null) {
            MediaModel mediaModel = this.bxi.get(i);
            aVar.bxP.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.bxQ.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.bxR.setVisibility(mediaModel.equals(this.bxN) ? 0 : 8);
            ImageRequestBuilder X = ImageRequestBuilder.X(Uri.fromFile(new File(mediaModel.getPath())));
            X.c(new d(this.bxO, this.bxO));
            X.vg(true);
            aVar.bxP.setController(com.facebook.drawee.a.a.c.djg().c(aVar.bxP.getController()).uR(false).be(X.dpZ()).djX());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bxi == null) {
            return 0;
        }
        return this.bxi.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView bxP;
        private View bxQ;
        private View bxR;

        a(View view) {
            super(view);
            this.bxP = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.bxQ = view.findViewById(a.f.album_thumbnail_video);
            this.bxR = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
