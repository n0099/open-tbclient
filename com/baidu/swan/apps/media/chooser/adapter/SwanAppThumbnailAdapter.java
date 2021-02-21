package com.baidu.swan.apps.media.chooser.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.facebook.drawee.a.a.c;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class SwanAppThumbnailAdapter extends RecyclerView.Adapter<a> {
    private MediaModel dkP;
    private int dkQ;
    private ArrayList<MediaModel> dkh;

    public SwanAppThumbnailAdapter(Context context) {
        this.dkQ = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> aBq() {
        return this.dkh;
    }

    public void n(ArrayList<MediaModel> arrayList) {
        this.dkh = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.dkP = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i;
        if (this.dkh == null) {
            return 0;
        }
        MediaModel mediaModel2 = this.dkP;
        this.dkP = mediaModel;
        int i2 = -1;
        int size = this.dkh.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            if (mediaModel2 == null || !mediaModel2.equals(this.dkh.get(i3))) {
                i = i4;
            } else {
                notifyItemChanged(i3);
                i = i4 + 1;
            }
            if (mediaModel != null && mediaModel.equals(this.dkh.get(i3))) {
                notifyItemChanged(i3);
                i++;
                i2 = i3;
            }
            if (i < 2) {
                i3++;
                i4 = i;
            } else {
                return i2;
            }
        }
        return i2;
    }

    public MediaModel ib(int i) {
        if (this.dkh == null || i < 0 || i >= this.dkh.size()) {
            return null;
        }
        return this.dkh.get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(a.g.swanapp_thumbnail_drag_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        if (this.dkh != null) {
            MediaModel mediaModel = this.dkh.get(i);
            aVar.dkR.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.dkS.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.dkT.setVisibility(mediaModel.equals(this.dkP) ? 0 : 8);
            ImageRequestBuilder ag = ImageRequestBuilder.ag(Uri.fromFile(new File(mediaModel.getPath())));
            ag.c(new d(this.dkQ, this.dkQ));
            ag.By(true);
            aVar.dkR.setController(c.etw().c(aVar.dkR.getController()).Bm(false).bo(ag.eAq()).eun());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dkh == null) {
            return 0;
        }
        return this.dkh.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView dkR;
        private View dkS;
        private View dkT;

        a(View view) {
            super(view);
            this.dkR = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.dkS = view.findViewById(a.f.album_thumbnail_video);
            this.dkT = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
