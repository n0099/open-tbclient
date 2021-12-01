package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.math.Rectangle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PixmapPacker$PixmapPackerRectangle extends Rectangle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int offsetX;
    public int offsetY;
    public int originalHeight;
    public int originalWidth;
    public int[] pads;
    public int[] splits;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PixmapPacker$PixmapPackerRectangle(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Float) objArr2[0]).floatValue(), ((Float) objArr2[1]).floatValue(), ((Float) objArr2[2]).floatValue(), ((Float) objArr2[3]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.offsetX = 0;
        this.offsetY = 0;
        this.originalWidth = i4;
        this.originalHeight = i5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PixmapPacker$PixmapPackerRectangle(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        super(i2, i3, i4, i5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i10 = newInitContext.flag;
            if ((i10 & 1) != 0) {
                int i11 = i10 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Float) objArr2[0]).floatValue(), ((Float) objArr2[1]).floatValue(), ((Float) objArr2[2]).floatValue(), ((Float) objArr2[3]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.offsetX = i6;
        this.offsetY = i7;
        this.originalWidth = i8;
        this.originalHeight = i9;
    }
}
