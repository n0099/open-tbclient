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
    private MediaModel cqO;
    private int cqP;
    private ArrayList<MediaModel> cqf;

    public c(Context context) {
        this.cqP = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> aka() {
        return this.cqf;
    }

    public void n(ArrayList<MediaModel> arrayList) {
        this.cqf = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.cqO = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i = 0;
        if (this.cqf != null) {
            MediaModel mediaModel2 = this.cqO;
            this.cqO = mediaModel;
            int size = this.cqf.size();
            i = -1;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.cqf.get(i3))) {
                    notifyItemChanged(i3);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.cqf.get(i3))) {
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

    public MediaModel fZ(int i) {
        if (this.cqf == null || i < 0 || i >= this.cqf.size()) {
            return null;
        }
        return this.cqf.get(i);
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
        if (this.cqf != null) {
            MediaModel mediaModel = this.cqf.get(i);
            aVar.cqQ.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.cqR.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.cqS.setVisibility(mediaModel.equals(this.cqO) ? 0 : 8);
            ImageRequestBuilder ac = ImageRequestBuilder.ac(Uri.fromFile(new File(mediaModel.getPath())));
            ac.c(new d(this.cqP, this.cqP));
            ac.wM(true);
            aVar.cqQ.setController(com.facebook.drawee.a.a.c.dzW().c(aVar.cqQ.getController()).wy(false).bc(ac.dHb()).dAN());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cqf == null) {
            return 0;
        }
        return this.cqf.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView cqQ;
        private View cqR;
        private View cqS;

        a(View view) {
            super(view);
            this.cqQ = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.cqR = view.findViewById(a.f.album_thumbnail_video);
            this.cqS = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
