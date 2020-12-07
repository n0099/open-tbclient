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
/* loaded from: classes25.dex */
public class c extends RecyclerView.Adapter<a> {
    private ArrayList<MediaModel> dhO;
    private MediaModel diy;
    private int diz;

    public c(Context context) {
        this.diz = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> aDt() {
        return this.dhO;
    }

    public void s(ArrayList<MediaModel> arrayList) {
        this.dhO = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.diy = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.dhO != null) {
            MediaModel mediaModel2 = this.diy;
            this.diy = mediaModel;
            int size = this.dhO.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.dhO.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.dhO.get(i3))) {
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

    public MediaModel jJ(int i) {
        if (this.dhO == null || i < 0 || i >= this.dhO.size()) {
            return null;
        }
        return this.dhO.get(i);
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
        if (this.dhO != null) {
            MediaModel mediaModel = this.dhO.get(i);
            aVar.diA.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.diB.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.diC.setVisibility(mediaModel.equals(this.diy) ? 0 : 8);
            ImageRequestBuilder af = ImageRequestBuilder.af(Uri.fromFile(new File(mediaModel.getPath())));
            af.c(new d(this.diz, this.diz));
            af.Bb(true);
            aVar.diA.setController(com.facebook.drawee.a.a.c.eqF().c(aVar.diA.getController()).AP(false).bo(af.exw()).erw());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dhO == null) {
            return 0;
        }
        return this.dhO.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView diA;
        private View diB;
        private View diC;

        a(View view) {
            super(view);
            this.diA = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.diB = view.findViewById(a.f.album_thumbnail_video);
            this.diC = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
