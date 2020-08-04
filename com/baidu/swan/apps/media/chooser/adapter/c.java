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
    private MediaModel csS;
    private int csT;
    private ArrayList<MediaModel> csj;

    public c(Context context) {
        this.csT = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> alq() {
        return this.csj;
    }

    public void n(ArrayList<MediaModel> arrayList) {
        this.csj = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.csS = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.csj != null) {
            MediaModel mediaModel2 = this.csS;
            this.csS = mediaModel;
            int size = this.csj.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.csj.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.csj.get(i3))) {
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

    public MediaModel gj(int i) {
        if (this.csj == null || i < 0 || i >= this.csj.size()) {
            return null;
        }
        return this.csj.get(i);
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
        if (this.csj != null) {
            MediaModel mediaModel = this.csj.get(i);
            aVar.csU.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.csV.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.csW.setVisibility(mediaModel.equals(this.csS) ? 0 : 8);
            ImageRequestBuilder ab = ImageRequestBuilder.ab(Uri.fromFile(new File(mediaModel.getPath())));
            ab.c(new d(this.csT, this.csT));
            ab.xr(true);
            aVar.csU.setController(com.facebook.drawee.a.a.c.dDn().c(aVar.csU.getController()).xd(false).bc(ab.dKs()).dEe());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.csj == null) {
            return 0;
        }
        return this.csj.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView csU;
        private View csV;
        private View csW;

        a(View view) {
            super(view);
            this.csU = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.csV = view.findViewById(a.f.album_thumbnail_video);
            this.csW = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
