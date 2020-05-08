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
    private ArrayList<MediaModel> caO;
    private MediaModel cbx;
    private int cby;

    public c(Context context) {
        this.cby = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> afF() {
        return this.caO;
    }

    public void n(ArrayList<MediaModel> arrayList) {
        this.caO = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.cbx = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.caO != null) {
            MediaModel mediaModel2 = this.cbx;
            this.cbx = mediaModel;
            int size = this.caO.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.caO.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.caO.get(i3))) {
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
        if (this.caO == null || i < 0 || i >= this.caO.size()) {
            return null;
        }
        return this.caO.get(i);
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
        if (this.caO != null) {
            MediaModel mediaModel = this.caO.get(i);
            aVar.cbz.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.cbA.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.cbB.setVisibility(mediaModel.equals(this.cbx) ? 0 : 8);
            ImageRequestBuilder Z = ImageRequestBuilder.Z(Uri.fromFile(new File(mediaModel.getPath())));
            Z.c(new d(this.cby, this.cby));
            Z.vQ(true);
            aVar.cbz.setController(com.facebook.drawee.a.a.c.dnM().c(aVar.cbz.getController()).vC(false).aX(Z.duT()).doD());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.caO == null) {
            return 0;
        }
        return this.caO.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends RecyclerView.ViewHolder {
        private View cbA;
        private View cbB;
        private SimpleDraweeView cbz;

        a(View view) {
            super(view);
            this.cbz = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.cbA = view.findViewById(a.f.album_thumbnail_video);
            this.cbB = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
