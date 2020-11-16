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
/* loaded from: classes7.dex */
public class c extends RecyclerView.Adapter<a> {
    private ArrayList<MediaModel> daQ;
    private MediaModel dbx;
    private int dby;

    public c(Context context) {
        this.dby = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> aAk() {
        return this.daQ;
    }

    public void s(ArrayList<MediaModel> arrayList) {
        this.daQ = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.dbx = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.daQ != null) {
            MediaModel mediaModel2 = this.dbx;
            this.dbx = mediaModel;
            int size = this.daQ.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.daQ.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.daQ.get(i3))) {
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

    public MediaModel jl(int i) {
        if (this.daQ == null || i < 0 || i >= this.daQ.size()) {
            return null;
        }
        return this.daQ.get(i);
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
        if (this.daQ != null) {
            MediaModel mediaModel = this.daQ.get(i);
            aVar.dbz.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.dbA.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.dbB.setVisibility(mediaModel.equals(this.dbx) ? 0 : 8);
            ImageRequestBuilder ae = ImageRequestBuilder.ae(Uri.fromFile(new File(mediaModel.getPath())));
            ae.c(new d(this.dby, this.dby));
            ae.AA(true);
            aVar.dbz.setController(com.facebook.drawee.a.a.c.ekQ().c(aVar.dbz.getController()).Am(false).bo(ae.erW()).elH());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.daQ == null) {
            return 0;
        }
        return this.daQ.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a extends RecyclerView.ViewHolder {
        private View dbA;
        private View dbB;
        private SimpleDraweeView dbz;

        a(View view) {
            super(view);
            this.dbz = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.dbA = view.findViewById(a.f.album_thumbnail_video);
            this.dbB = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
