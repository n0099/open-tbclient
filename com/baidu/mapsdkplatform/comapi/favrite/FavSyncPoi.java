package com.baidu.mapsdkplatform.comapi.favrite;

import com.baidu.mapapi.model.inner.Point;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class FavSyncPoi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f7624a;

    /* renamed from: b  reason: collision with root package name */
    public String f7625b;

    /* renamed from: c  reason: collision with root package name */
    public Point f7626c;

    /* renamed from: d  reason: collision with root package name */
    public String f7627d;

    /* renamed from: e  reason: collision with root package name */
    public String f7628e;

    /* renamed from: f  reason: collision with root package name */
    public String f7629f;

    /* renamed from: g  reason: collision with root package name */
    public int f7630g;

    /* renamed from: h  reason: collision with root package name */
    public String f7631h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7632i;
    public String j;

    public FavSyncPoi() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
