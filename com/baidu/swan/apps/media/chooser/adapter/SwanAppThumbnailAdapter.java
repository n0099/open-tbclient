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
    private ArrayList<MediaModel> dmI;
    private MediaModel dnq;
    private int dnr;

    public SwanAppThumbnailAdapter(Context context) {
        this.dnr = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> aEL() {
        return this.dmI;
    }

    public void s(ArrayList<MediaModel> arrayList) {
        this.dmI = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.dnq = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i;
        if (this.dmI == null) {
            return 0;
        }
        MediaModel mediaModel2 = this.dnq;
        this.dnq = mediaModel;
        int i2 = -1;
        int size = this.dmI.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            if (mediaModel2 == null || !mediaModel2.equals(this.dmI.get(i3))) {
                i = i4;
            } else {
                notifyItemChanged(i3);
                i = i4 + 1;
            }
            if (mediaModel != null && mediaModel.equals(this.dmI.get(i3))) {
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

    public MediaModel jE(int i) {
        if (this.dmI == null || i < 0 || i >= this.dmI.size()) {
            return null;
        }
        return this.dmI.get(i);
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
        if (this.dmI != null) {
            MediaModel mediaModel = this.dmI.get(i);
            aVar.dnt.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.dnu.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.dnv.setVisibility(mediaModel.equals(this.dnq) ? 0 : 8);
            ImageRequestBuilder aj = ImageRequestBuilder.aj(Uri.fromFile(new File(mediaModel.getPath())));
            aj.c(new d(this.dnr, this.dnr));
            aj.Bj(true);
            aVar.dnt.setController(c.euI().c(aVar.dnt.getController()).AX(false).bo(aj.eBe()).evz());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dmI == null) {
            return 0;
        }
        return this.dmI.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView dnt;
        private View dnu;
        private View dnv;

        a(View view) {
            super(view);
            this.dnt = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.dnu = view.findViewById(a.f.album_thumbnail_video);
            this.dnv = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
