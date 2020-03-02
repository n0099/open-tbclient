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
    private MediaModel bCI;
    private int bCJ;
    private ArrayList<MediaModel> bCd;

    public c(Context context) {
        this.bCJ = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> XG() {
        return this.bCd;
    }

    public void n(ArrayList<MediaModel> arrayList) {
        this.bCd = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.bCI = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.bCd != null) {
            MediaModel mediaModel2 = this.bCI;
            this.bCI = mediaModel;
            int size = this.bCd.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.bCd.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.bCd.get(i3))) {
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
        if (this.bCd == null || i < 0 || i >= this.bCd.size()) {
            return null;
        }
        return this.bCd.get(i);
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
        if (this.bCd != null) {
            MediaModel mediaModel = this.bCd.get(i);
            aVar.bCK.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.bCL.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.bCM.setVisibility(mediaModel.equals(this.bCI) ? 0 : 8);
            ImageRequestBuilder Y = ImageRequestBuilder.Y(Uri.fromFile(new File(mediaModel.getPath())));
            Y.c(new d(this.bCJ, this.bCJ));
            Y.vw(true);
            aVar.bCK.setController(com.facebook.drawee.a.a.c.dly().c(aVar.bCK.getController()).vh(false).bg(Y.dsC()).dmp());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bCd == null) {
            return 0;
        }
        return this.bCd.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView bCK;
        private View bCL;
        private View bCM;

        a(View view) {
            super(view);
            this.bCK = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.bCL = view.findViewById(a.f.album_thumbnail_video);
            this.bCM = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
