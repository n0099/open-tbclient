package com.baidu.swan.apps.media.chooser.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.b.g0.a.d;
import d.b.g0.a.f;
import d.b.g0.a.g;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SwanAppThumbnailAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MediaModel> f12329a;

    /* renamed from: b  reason: collision with root package name */
    public MediaModel f12330b;

    /* renamed from: c  reason: collision with root package name */
    public int f12331c;

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f12332a;

        /* renamed from: b  reason: collision with root package name */
        public View f12333b;

        /* renamed from: c  reason: collision with root package name */
        public View f12334c;

        public a(SwanAppThumbnailAdapter swanAppThumbnailAdapter, View view) {
            super(view);
            this.f12332a = (SimpleDraweeView) view.findViewById(f.drag_photo_view);
            this.f12333b = view.findViewById(f.album_thumbnail_video);
            this.f12334c = view.findViewById(f.album_thumbnail_selected);
        }
    }

    public SwanAppThumbnailAdapter(Context context) {
        this.f12331c = context.getResources().getDimensionPixelSize(d.swanapp_preview_thumbnail);
    }

    public MediaModel g(int i) {
        ArrayList<MediaModel> arrayList = this.f12329a;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.f12329a.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<MediaModel> arrayList = this.f12329a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ArrayList<MediaModel> m() {
        return this.f12329a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(a aVar, int i) {
        ArrayList<MediaModel> arrayList = this.f12329a;
        if (arrayList == null) {
            return;
        }
        MediaModel mediaModel = arrayList.get(i);
        aVar.f12332a.setImageURI(Uri.fromFile(new File(mediaModel.b())));
        aVar.f12333b.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
        aVar.f12334c.setVisibility(mediaModel.equals(this.f12330b) ? 0 : 8);
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(mediaModel.b())));
        int i2 = this.f12331c;
        newBuilderWithSource.setResizeOptions(new ResizeOptions(i2, i2));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        aVar.f12332a.setController(Fresco.newDraweeControllerBuilder().setOldController(aVar.f12332a.getController()).setAutoPlayAnimations(false).setImageRequest(newBuilderWithSource.build()).build());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(g.swanapp_thumbnail_drag_item, viewGroup, false));
    }

    public int p(MediaModel mediaModel) {
        ArrayList<MediaModel> arrayList = this.f12329a;
        if (arrayList == null) {
            return 0;
        }
        MediaModel mediaModel2 = this.f12330b;
        this.f12330b = mediaModel;
        int size = arrayList.size();
        int i = 0;
        int i2 = -1;
        for (int i3 = 0; i3 < size; i3++) {
            if (mediaModel2 != null && mediaModel2.equals(this.f12329a.get(i3))) {
                notifyItemChanged(i3);
                i++;
            }
            if (mediaModel != null && mediaModel.equals(this.f12329a.get(i3))) {
                notifyItemChanged(i3);
                i++;
                i2 = i3;
            }
            if (i >= 2) {
                break;
            }
        }
        return i2;
    }

    public void q(ArrayList<MediaModel> arrayList) {
        this.f12329a = arrayList;
        if (arrayList != null && arrayList.size() == 1) {
            this.f12330b = arrayList.get(0);
        }
        notifyDataSetChanged();
    }
}
