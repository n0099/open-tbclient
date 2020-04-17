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
    private ArrayList<MediaModel> caI;
    private MediaModel cbr;
    private int cbs;

    public c(Context context) {
        this.cbs = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> afG() {
        return this.caI;
    }

    public void n(ArrayList<MediaModel> arrayList) {
        this.caI = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.cbr = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.caI != null) {
            MediaModel mediaModel2 = this.cbr;
            this.cbr = mediaModel;
            int size = this.caI.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.caI.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.caI.get(i3))) {
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

    public MediaModel fy(int i) {
        if (this.caI == null || i < 0 || i >= this.caI.size()) {
            return null;
        }
        return this.caI.get(i);
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
        if (this.caI != null) {
            MediaModel mediaModel = this.caI.get(i);
            aVar.cbt.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.cbu.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.cbv.setVisibility(mediaModel.equals(this.cbr) ? 0 : 8);
            ImageRequestBuilder Z = ImageRequestBuilder.Z(Uri.fromFile(new File(mediaModel.getPath())));
            Z.c(new d(this.cbs, this.cbs));
            Z.vQ(true);
            aVar.cbt.setController(com.facebook.drawee.a.a.c.dnP().c(aVar.cbt.getController()).vC(false).aW(Z.duW()).doG());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.caI == null) {
            return 0;
        }
        return this.caI.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView cbt;
        private View cbu;
        private View cbv;

        a(View view) {
            super(view);
            this.cbt = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.cbu = view.findViewById(a.f.album_thumbnail_video);
            this.cbv = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
