package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.f.b;
import d.a.o0.f.c;
/* loaded from: classes3.dex */
public class ListRecommendDivider extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f11975a;

    /* renamed from: b  reason: collision with root package name */
    public int f11976b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f11977c;

    public ListRecommendDivider(@NonNull Context context) {
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
        Resources resources = context.getResources();
        this.f11975a = resources.getDimensionPixelSize(c.swangame_recommend_dialog_list_divider_height);
        this.f11976b = resources.getDimensionPixelSize(c.swangame_recommend_dialog_list_divider_margin);
        Paint paint = new Paint();
        this.f11977c = paint;
        paint.setColor(resources.getColor(b.swangame_recommend_dialog_list_divider));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
            rect.set(0, 0, 0, this.f11975a);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, recyclerView, state) == null) {
            int itemCount = recyclerView.getAdapter().getItemCount();
            for (int i2 = 0; i2 < itemCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (childAt != null && recyclerView.getChildAdapterPosition(childAt) != itemCount - 1) {
                    canvas.drawRect(this.f11976b, childAt.getBottom(), childAt.getWidth() - this.f11976b, childAt.getBottom() + this.f11975a, this.f11977c);
                }
            }
        }
    }
}
