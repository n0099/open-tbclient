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
/* loaded from: classes8.dex */
public class SwanAppThumbnailAdapter extends RecyclerView.Adapter<a> {
    private ArrayList<MediaModel> dlI;
    private MediaModel dmq;
    private int dmr;

    public SwanAppThumbnailAdapter(Context context) {
        this.dmr = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> aBt() {
        return this.dlI;
    }

    public void n(ArrayList<MediaModel> arrayList) {
        this.dlI = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.dmq = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i;
        if (this.dlI == null) {
            return 0;
        }
        MediaModel mediaModel2 = this.dmq;
        this.dmq = mediaModel;
        int i2 = -1;
        int size = this.dlI.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            if (mediaModel2 == null || !mediaModel2.equals(this.dlI.get(i3))) {
                i = i4;
            } else {
                notifyItemChanged(i3);
                i = i4 + 1;
            }
            if (mediaModel != null && mediaModel.equals(this.dlI.get(i3))) {
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

    public MediaModel ic(int i) {
        if (this.dlI == null || i < 0 || i >= this.dlI.size()) {
            return null;
        }
        return this.dlI.get(i);
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
        if (this.dlI != null) {
            MediaModel mediaModel = this.dlI.get(i);
            aVar.dms.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.dmt.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.dmu.setVisibility(mediaModel.equals(this.dmq) ? 0 : 8);
            ImageRequestBuilder ag = ImageRequestBuilder.ag(Uri.fromFile(new File(mediaModel.getPath())));
            ag.c(new d(this.dmr, this.dmr));
            ag.Bw(true);
            aVar.dms.setController(c.etF().c(aVar.dms.getController()).Bk(false).bq(ag.eAz()).euw());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dlI == null) {
            return 0;
        }
        return this.dlI.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView dms;
        private View dmt;
        private View dmu;

        a(View view) {
            super(view);
            this.dms = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.dmt = view.findViewById(a.f.album_thumbnail_video);
            this.dmu = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
