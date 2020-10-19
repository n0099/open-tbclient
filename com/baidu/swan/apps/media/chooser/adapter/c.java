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
    private MediaModel cOP;
    private int cOQ;
    private ArrayList<MediaModel> cOi;

    public c(Context context) {
        this.cOQ = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> awy() {
        return this.cOi;
    }

    public void s(ArrayList<MediaModel> arrayList) {
        this.cOi = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.cOP = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.cOi != null) {
            MediaModel mediaModel2 = this.cOP;
            this.cOP = mediaModel;
            int size = this.cOi.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.cOi.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.cOi.get(i3))) {
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

    public MediaModel iU(int i) {
        if (this.cOi == null || i < 0 || i >= this.cOi.size()) {
            return null;
        }
        return this.cOi.get(i);
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
        if (this.cOi != null) {
            MediaModel mediaModel = this.cOi.get(i);
            aVar.cOR.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.cOS.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.cOT.setVisibility(mediaModel.equals(this.cOP) ? 0 : 8);
            ImageRequestBuilder ad = ImageRequestBuilder.ad(Uri.fromFile(new File(mediaModel.getPath())));
            ad.c(new d(this.cOQ, this.cOQ));
            ad.za(true);
            aVar.cOR.setController(com.facebook.drawee.a.a.c.dXf().c(aVar.cOR.getController()).yM(false).bj(ad.eej()).dXW());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cOi == null) {
            return 0;
        }
        return this.cOi.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView cOR;
        private View cOS;
        private View cOT;

        a(View view) {
            super(view);
            this.cOR = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.cOS = view.findViewById(a.f.album_thumbnail_video);
            this.cOT = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
