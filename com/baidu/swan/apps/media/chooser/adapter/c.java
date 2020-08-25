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
    private MediaModel cAG;
    private int cAH;
    private ArrayList<MediaModel> czZ;

    public c(Context context) {
        this.cAH = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> ate() {
        return this.czZ;
    }

    public void s(ArrayList<MediaModel> arrayList) {
        this.czZ = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.cAG = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.czZ != null) {
            MediaModel mediaModel2 = this.cAG;
            this.cAG = mediaModel;
            int size = this.czZ.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.czZ.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.czZ.get(i3))) {
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
        if (this.czZ == null || i < 0 || i >= this.czZ.size()) {
            return null;
        }
        return this.czZ.get(i);
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
        if (this.czZ != null) {
            MediaModel mediaModel = this.czZ.get(i);
            aVar.cAI.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.cAJ.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.cAK.setVisibility(mediaModel.equals(this.cAG) ? 0 : 8);
            ImageRequestBuilder ab = ImageRequestBuilder.ab(Uri.fromFile(new File(mediaModel.getPath())));
            ab.c(new d(this.cAH, this.cAH));
            ab.yi(true);
            aVar.cAI.setController(com.facebook.drawee.a.a.c.dPn().c(aVar.cAI.getController()).xU(false).be(ab.dWr()).dQe());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.czZ == null) {
            return 0;
        }
        return this.czZ.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView cAI;
        private View cAJ;
        private View cAK;

        a(View view) {
            super(view);
            this.cAI = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.cAJ = view.findViewById(a.f.album_thumbnail_video);
            this.cAK = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
