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
    private MediaModel bCH;
    private int bCI;
    private ArrayList<MediaModel> bCc;

    public c(Context context) {
        this.bCI = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> XE() {
        return this.bCc;
    }

    public void n(ArrayList<MediaModel> arrayList) {
        this.bCc = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.bCH = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.bCc != null) {
            MediaModel mediaModel2 = this.bCH;
            this.bCH = mediaModel;
            int size = this.bCc.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.bCc.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.bCc.get(i3))) {
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
        if (this.bCc == null || i < 0 || i >= this.bCc.size()) {
            return null;
        }
        return this.bCc.get(i);
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
        if (this.bCc != null) {
            MediaModel mediaModel = this.bCc.get(i);
            aVar.bCJ.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.bCK.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.bCL.setVisibility(mediaModel.equals(this.bCH) ? 0 : 8);
            ImageRequestBuilder Y = ImageRequestBuilder.Y(Uri.fromFile(new File(mediaModel.getPath())));
            Y.c(new d(this.bCI, this.bCI));
            Y.vw(true);
            aVar.bCJ.setController(com.facebook.drawee.a.a.c.dlw().c(aVar.bCJ.getController()).vh(false).bg(Y.dsA()).dmn());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bCc == null) {
            return 0;
        }
        return this.bCc.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView bCJ;
        private View bCK;
        private View bCL;

        a(View view) {
            super(view);
            this.bCJ = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.bCK = view.findViewById(a.f.album_thumbnail_video);
            this.bCL = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
