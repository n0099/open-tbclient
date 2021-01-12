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
    private ArrayList<MediaModel> dhT;
    private MediaModel diE;
    private int diF;

    public SwanAppThumbnailAdapter(Context context) {
        this.diF = context.getResources().getDimensionPixelSize(a.d.swanapp_preview_thumbnail);
    }

    public ArrayList<MediaModel> aAS() {
        return this.dhT;
    }

    public void n(ArrayList<MediaModel> arrayList) {
        this.dhT = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.diE = arrayList.get(0);
        }
        notifyDataSetChanged();
    }

    public int b(MediaModel mediaModel) {
        int i;
        if (this.dhT == null) {
            return 0;
        }
        MediaModel mediaModel2 = this.diE;
        this.diE = mediaModel;
        int i2 = -1;
        int size = this.dhT.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            if (mediaModel2 == null || !mediaModel2.equals(this.dhT.get(i3))) {
                i = i4;
            } else {
                notifyItemChanged(i3);
                i = i4 + 1;
            }
            if (mediaModel != null && mediaModel.equals(this.dhT.get(i3))) {
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

    public MediaModel hY(int i) {
        if (this.dhT == null || i < 0 || i >= this.dhT.size()) {
            return null;
        }
        return this.dhT.get(i);
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
        if (this.dhT != null) {
            MediaModel mediaModel = this.dhT.get(i);
            aVar.diG.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
            aVar.diH.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
            aVar.diI.setVisibility(mediaModel.equals(this.diE) ? 0 : 8);
            ImageRequestBuilder ag = ImageRequestBuilder.ag(Uri.fromFile(new File(mediaModel.getPath())));
            ag.c(new d(this.diF, this.diF));
            ag.Bf(true);
            aVar.diG.setController(c.eqV().c(aVar.diG.getController()).AT(false).bo(ag.exQ()).erN());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dhT == null) {
            return 0;
        }
        return this.dhT.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends RecyclerView.ViewHolder {
        private SimpleDraweeView diG;
        private View diH;
        private View diI;

        a(View view) {
            super(view);
            this.diG = (SimpleDraweeView) view.findViewById(a.f.drag_photo_view);
            this.diH = view.findViewById(a.f.album_thumbnail_video);
            this.diI = view.findViewById(a.f.album_thumbnail_selected);
        }
    }
}
