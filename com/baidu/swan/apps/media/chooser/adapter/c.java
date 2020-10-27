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
    private ArrayList<MediaModel> cWE;
    private MediaModel cXl;
    private int cXm;

    public c(Context context) {
        this.cXm = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> ays() {
        return this.cWE;
    }

    public void s(ArrayList<MediaModel> arrayList) {
        this.cWE = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.cXl = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.cWE != null) {
            MediaModel mediaModel2 = this.cXl;
            this.cXl = mediaModel;
            int size = this.cWE.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.cWE.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.cWE.get(i3))) {
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

    public MediaModel jf(int i) {
        if (this.cWE == null || i < 0 || i >= this.cWE.size()) {
            return null;
        }
        return this.cWE.get(i);
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
        if (this.cWE != null) {
            MediaModel mediaModel = this.cWE.get(i);
            aVar.cXn.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.cXo.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.cXp.setVisibility(mediaModel.equals(this.cXl) ? 0 : 8);
            ImageRequestBuilder ad = ImageRequestBuilder.ad(Uri.fromFile(new File(mediaModel.getPath())));
            ad.c(new d(this.cXm, this.cXm));
            ad.Ai(true);
            aVar.cXn.setController(com.facebook.drawee.a.a.c.ehd().c(aVar.cXn.getController()).zU(false).bn(ad.eoj()).ehU());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cWE == null) {
            return 0;
        }
        return this.cWE.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView cXn;
        private View cXo;
        private View cXp;

        a(View view) {
            super(view);
            this.cXn = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.cXo = view.findViewById(a.f.album_thumbnail_video);
            this.cXp = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
