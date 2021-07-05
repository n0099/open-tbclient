package com.baidu.swan.apps.media.chooser.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.a.q0.a.d;
import d.a.q0.a.f;
import d.a.q0.a.g;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class SwanAppThumbnailAdapter extends RecyclerView.Adapter<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MediaModel> f11126a;

    /* renamed from: b  reason: collision with root package name */
    public MediaModel f11127b;

    /* renamed from: c  reason: collision with root package name */
    public int f11128c;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f11129a;

        /* renamed from: b  reason: collision with root package name */
        public View f11130b;

        /* renamed from: c  reason: collision with root package name */
        public View f11131c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SwanAppThumbnailAdapter swanAppThumbnailAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppThumbnailAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11129a = (SimpleDraweeView) view.findViewById(f.drag_photo_view);
            this.f11130b = view.findViewById(f.album_thumbnail_video);
            this.f11131c = view.findViewById(f.album_thumbnail_selected);
        }
    }

    public SwanAppThumbnailAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11128c = context.getResources().getDimensionPixelSize(d.swanapp_preview_thumbnail);
    }

    public MediaModel g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            ArrayList<MediaModel> arrayList = this.f11126a;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f11126a.get(i2);
        }
        return (MediaModel) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<MediaModel> arrayList = this.f11126a;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public ArrayList<MediaModel> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11126a : (ArrayList) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(a aVar, int i2) {
        ArrayList<MediaModel> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, aVar, i2) == null) || (arrayList = this.f11126a) == null) {
            return;
        }
        MediaModel mediaModel = arrayList.get(i2);
        aVar.f11129a.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
        aVar.f11130b.setVisibility(mediaModel instanceof VideoModel ? 0 : 8);
        aVar.f11131c.setVisibility(mediaModel.equals(this.f11127b) ? 0 : 8);
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(mediaModel.getPath())));
        int i3 = this.f11128c;
        newBuilderWithSource.setResizeOptions(new ResizeOptions(i3, i3));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setOldController(aVar.f11129a.getController()).setAutoPlayAnimations(false).setImageRequest(newBuilderWithSource.build()).build();
        aVar.f11129a.setController(build);
        DraweeHierarchy hierarchy = build.getHierarchy();
        if (hierarchy instanceof GenericDraweeHierarchy) {
            d.a.q0.a.c1.a.y().c((GenericDraweeHierarchy) hierarchy, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) ? new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(g.swanapp_thumbnail_drag_item, viewGroup, false)) : (a) invokeLI.objValue;
    }

    public int p(MediaModel mediaModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, mediaModel)) == null) {
            ArrayList<MediaModel> arrayList = this.f11126a;
            if (arrayList == null) {
                return 0;
            }
            MediaModel mediaModel2 = this.f11127b;
            this.f11127b = mediaModel;
            int size = arrayList.size();
            int i2 = 0;
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                if (mediaModel2 != null && mediaModel2.equals(this.f11126a.get(i4))) {
                    notifyItemChanged(i4);
                    i2++;
                }
                if (mediaModel != null && mediaModel.equals(this.f11126a.get(i4))) {
                    notifyItemChanged(i4);
                    i2++;
                    i3 = i4;
                }
                if (i2 >= 2) {
                    break;
                }
            }
            return i3;
        }
        return invokeL.intValue;
    }

    public void q(ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            this.f11126a = arrayList;
            if (arrayList != null && arrayList.size() == 1) {
                this.f11127b = arrayList.get(0);
            }
            notifyDataSetChanged();
        }
    }
}
