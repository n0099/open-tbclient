package com.baidu.mapsdkplatform.comapi.favrite;

import com.baidu.mapapi.model.inner.Point;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class FavSyncPoi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f40862a;

    /* renamed from: b  reason: collision with root package name */
    public String f40863b;

    /* renamed from: c  reason: collision with root package name */
    public Point f40864c;

    /* renamed from: d  reason: collision with root package name */
    public String f40865d;

    /* renamed from: e  reason: collision with root package name */
    public String f40866e;

    /* renamed from: f  reason: collision with root package name */
    public String f40867f;

    /* renamed from: g  reason: collision with root package name */
    public int f40868g;

    /* renamed from: h  reason: collision with root package name */
    public String f40869h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40870i;
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
