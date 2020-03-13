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
/* loaded from: classes11.dex */
public class c extends RecyclerView.Adapter<a> {
    private MediaModel bCJ;
    private int bCK;
    private ArrayList<MediaModel> bCe;

    public c(Context context) {
        this.bCK = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> XG() {
        return this.bCe;
    }

    public void n(ArrayList<MediaModel> arrayList) {
        this.bCe = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.bCJ = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.bCe != null) {
            MediaModel mediaModel2 = this.bCJ;
            this.bCJ = mediaModel;
            int size = this.bCe.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.bCe.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.bCe.get(i3))) {
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

    public MediaModel fr(int i) {
        if (this.bCe == null || i < 0 || i >= this.bCe.size()) {
            return null;
        }
        return this.bCe.get(i);
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
        if (this.bCe != null) {
            MediaModel mediaModel = this.bCe.get(i);
            aVar.bCL.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.bCM.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.bCN.setVisibility(mediaModel.equals(this.bCJ) ? 0 : 8);
            ImageRequestBuilder Y = ImageRequestBuilder.Y(Uri.fromFile(new File(mediaModel.getPath())));
            Y.c(new d(this.bCK, this.bCK));
            Y.vw(true);
            aVar.bCL.setController(com.facebook.drawee.a.a.c.dlz().c(aVar.bCL.getController()).vh(false).bg(Y.dsD()).dmq());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bCe == null) {
            return 0;
        }
        return this.bCe.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView bCL;
        private View bCM;
        private View bCN;

        a(View view) {
            super(view);
            this.bCL = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.bCM = view.findViewById(a.f.album_thumbnail_video);
            this.bCN = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
