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
    private MediaModel bCU;
    private int bCV;
    private ArrayList<MediaModel> bCp;

    public c(Context context) {
        this.bCV = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> XJ() {
        return this.bCp;
    }

    public void n(ArrayList<MediaModel> arrayList) {
        this.bCp = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.bCU = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.bCp != null) {
            MediaModel mediaModel2 = this.bCU;
            this.bCU = mediaModel;
            int size = this.bCp.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.bCp.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.bCp.get(i3))) {
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
        if (this.bCp == null || i < 0 || i >= this.bCp.size()) {
            return null;
        }
        return this.bCp.get(i);
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
        if (this.bCp != null) {
            MediaModel mediaModel = this.bCp.get(i);
            aVar.bCW.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.bCX.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.bCY.setVisibility(mediaModel.equals(this.bCU) ? 0 : 8);
            ImageRequestBuilder Y = ImageRequestBuilder.Y(Uri.fromFile(new File(mediaModel.getPath())));
            Y.c(new d(this.bCV, this.bCV));
            Y.vD(true);
            aVar.bCW.setController(com.facebook.drawee.a.a.c.dlW().c(aVar.bCW.getController()).vo(false).bg(Y.dta()).dmN());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bCp == null) {
            return 0;
        }
        return this.bCp.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView bCW;
        private View bCX;
        private View bCY;

        a(View view) {
            super(view);
            this.bCW = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.bCX = view.findViewById(a.f.album_thumbnail_video);
            this.bCY = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
