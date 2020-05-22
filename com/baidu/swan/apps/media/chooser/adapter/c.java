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
    private ArrayList<MediaModel> clr;
    private MediaModel cma;
    private int cmb;

    public c(Context context) {
        this.cmb = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> aiU() {
        return this.clr;
    }

    public void n(ArrayList<MediaModel> arrayList) {
        this.clr = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.cma = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.clr != null) {
            MediaModel mediaModel2 = this.cma;
            this.cma = mediaModel;
            int size = this.clr.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.clr.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.clr.get(i3))) {
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

    public MediaModel fM(int i) {
        if (this.clr == null || i < 0 || i >= this.clr.size()) {
            return null;
        }
        return this.clr.get(i);
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
        if (this.clr != null) {
            MediaModel mediaModel = this.clr.get(i);
            aVar.cmc.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.cme.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.cmf.setVisibility(mediaModel.equals(this.cma) ? 0 : 8);
            ImageRequestBuilder ab = ImageRequestBuilder.ab(Uri.fromFile(new File(mediaModel.getPath())));
            ab.c(new d(this.cmb, this.cmb));
            ab.wo(true);
            aVar.cmc.setController(com.facebook.drawee.a.a.c.dvf().c(aVar.cmc.getController()).wa(false).bb(ab.dCl()).dvW());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.clr == null) {
            return 0;
        }
        return this.clr.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView cmc;
        private View cme;
        private View cmf;

        a(View view) {
            super(view);
            this.cmc = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.cme = view.findViewById(a.f.album_thumbnail_video);
            this.cmf = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
