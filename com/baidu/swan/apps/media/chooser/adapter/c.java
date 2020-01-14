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
/* loaded from: classes10.dex */
public class c extends RecyclerView.Adapter<a> {
    private ArrayList<MediaModel> bxV;
    private MediaModel byA;
    private int byB;

    public c(Context context) {
        this.byB = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> Vq() {
        return this.bxV;
    }

    public void l(ArrayList<MediaModel> arrayList) {
        this.bxV = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.byA = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.bxV != null) {
            MediaModel mediaModel2 = this.byA;
            this.byA = mediaModel;
            int size = this.bxV.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.bxV.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.bxV.get(i3))) {
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

    public MediaModel fb(int i) {
        if (this.bxV == null || i < 0 || i >= this.bxV.size()) {
            return null;
        }
        return this.bxV.get(i);
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
        if (this.bxV != null) {
            MediaModel mediaModel = this.bxV.get(i);
            aVar.byC.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.byD.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.byE.setVisibility(mediaModel.equals(this.byA) ? 0 : 8);
            ImageRequestBuilder X = ImageRequestBuilder.X(Uri.fromFile(new File(mediaModel.getPath())));
            X.c(new d(this.byB, this.byB));
            X.vs(true);
            aVar.byC.setController(com.facebook.drawee.a.a.c.dkj().c(aVar.byC.getController()).vd(false).be(X.dro()).dla());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bxV == null) {
            return 0;
        }
        return this.bxV.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView byC;
        private View byD;
        private View byE;

        a(View view) {
            super(view);
            this.byC = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.byD = view.findViewById(a.f.album_thumbnail_video);
            this.byE = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
