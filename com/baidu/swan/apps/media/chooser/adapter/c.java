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
    private ArrayList<MediaModel> dcz;
    private MediaModel ddg;
    private int ddh;

    public c(Context context) {
        this.ddh = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> aAS() {
        return this.dcz;
    }

    public void s(ArrayList<MediaModel> arrayList) {
        this.dcz = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.ddg = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.dcz != null) {
            MediaModel mediaModel2 = this.ddg;
            this.ddg = mediaModel;
            int size = this.dcz.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.dcz.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.dcz.get(i3))) {
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

    public MediaModel jp(int i) {
        if (this.dcz == null || i < 0 || i >= this.dcz.size()) {
            return null;
        }
        return this.dcz.get(i);
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
        if (this.dcz != null) {
            MediaModel mediaModel = this.dcz.get(i);
            aVar.ddi.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.ddj.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.ddk.setVisibility(mediaModel.equals(this.ddg) ? 0 : 8);
            ImageRequestBuilder ad = ImageRequestBuilder.ad(Uri.fromFile(new File(mediaModel.getPath())));
            ad.c(new d(this.ddh, this.ddh));
            ad.At(true);
            aVar.ddi.setController(com.facebook.drawee.a.a.c.ekS().c(aVar.ddi.getController()).Af(false).bn(ad.erY()).elJ());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dcz == null) {
            return 0;
        }
        return this.dcz.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView ddi;
        private View ddj;
        private View ddk;

        a(View view) {
            super(view);
            this.ddi = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.ddj = view.findViewById(a.f.album_thumbnail_video);
            this.ddk = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
