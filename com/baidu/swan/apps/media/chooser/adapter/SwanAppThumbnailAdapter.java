package com.baidu.swan.apps.media.chooser.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.tieba.R;
import com.baidu.tieba.tm2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SwanAppThumbnailAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList a;
    public MediaModel b;
    public int c;

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SimpleDraweeView a;
        public View b;
        public View c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SwanAppThumbnailAdapter swanAppThumbnailAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppThumbnailAdapter, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f09085a);
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f090264);
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f090263);
        }
    }

    public SwanAppThumbnailAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0706da);
    }

    public MediaModel d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ArrayList arrayList = this.a;
            if (arrayList != null && i >= 0 && i < arrayList.size()) {
                return (MediaModel) this.a.get(i);
            }
            return null;
        }
        return (MediaModel) invokeI.objValue;
    }

    public void i(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.a = arrayList;
            if (arrayList != null && arrayList.size() == 1) {
                this.b = (MediaModel) arrayList.get(0);
            }
            notifyDataSetChanged();
        }
    }

    public ArrayList e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = this.a;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(a aVar, int i) {
        ArrayList arrayList;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, aVar, i) != null) || (arrayList = this.a) == null) {
            return;
        }
        MediaModel mediaModel = (MediaModel) arrayList.get(i);
        aVar.a.setImageURI(Uri.fromFile(new File(mediaModel.getPath())));
        View view2 = aVar.b;
        int i3 = 8;
        if (mediaModel instanceof VideoModel) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        view2.setVisibility(i2);
        View view3 = aVar.c;
        if (mediaModel.equals(this.b)) {
            i3 = 0;
        }
        view3.setVisibility(i3);
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(mediaModel.getPath())));
        int i4 = this.c;
        newBuilderWithSource.setResizeOptions(new ResizeOptions(i4, i4));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setOldController(aVar.a.getController())).setAutoPlayAnimations(false)).setImageRequest(newBuilderWithSource.build())).build();
        aVar.a.setController(build);
        DraweeHierarchy hierarchy = build.getHierarchy();
        if (hierarchy instanceof GenericDraweeHierarchy) {
            tm2.C().c((GenericDraweeHierarchy) hierarchy, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0834, viewGroup, false));
        }
        return (a) invokeLI.objValue;
    }

    public int h(MediaModel mediaModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mediaModel)) == null) {
            ArrayList arrayList = this.a;
            if (arrayList == null) {
                return 0;
            }
            MediaModel mediaModel2 = this.b;
            this.b = mediaModel;
            int size = arrayList.size();
            int i = 0;
            int i2 = -1;
            for (int i3 = 0; i3 < size; i3++) {
                if (mediaModel2 != null && mediaModel2.equals(this.a.get(i3))) {
                    notifyItemChanged(i3);
                    i++;
                }
                if (mediaModel != null && mediaModel.equals(this.a.get(i3))) {
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
        return invokeL.intValue;
    }
}
