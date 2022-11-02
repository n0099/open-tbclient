package com.baidu.platform.comapi.map;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ag extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<GeoPoint> k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(ap apVar) {
        super(apVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {apVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ap) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        this.i = 0;
        this.j = 2;
    }

    public void a(List<GeoPoint> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            if (list != null) {
                if (list.size() >= 2) {
                    synchronized (this.k) {
                        this.k.clear();
                        this.k.addAll(list);
                        this.g = true;
                    }
                    return;
                }
                throw new IllegalArgumentException("points count can not be less than two!");
            }
            throw new IllegalArgumentException("points list can not be null!");
        }
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            synchronized (this.k) {
                if (this.k.size() < 2) {
                    return false;
                }
                int size = this.k.size();
                this.d = new double[(this.k.size() * 2) + 5];
                if (c()) {
                    this.d[0] = this.e.getLongitude();
                    this.d[1] = this.e.getLatitude();
                    this.d[2] = this.f.getLongitude();
                    this.d[3] = this.f.getLatitude();
                }
                this.d[4] = 2.0d;
                this.d[5] = this.k.get(0).getLongitude();
                this.d[6] = this.k.get(0).getLatitude();
                for (int i = 1; i < size; i++) {
                    int i2 = (i * 2) + 5;
                    int i3 = i - 1;
                    this.d[i2] = this.k.get(i).getLongitude() - this.k.get(i3).getLongitude();
                    this.d[i2 + 1] = this.k.get(i).getLatitude() - this.k.get(i3).getLatitude();
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this.k) {
                if (this.k.size() < 2) {
                    return false;
                }
                this.e.setLatitude(this.k.get(0).getLatitude());
                this.e.setLongitude(this.k.get(0).getLongitude());
                this.f.setLatitude(this.k.get(0).getLatitude());
                this.f.setLongitude(this.k.get(0).getLongitude());
                for (GeoPoint geoPoint : this.k) {
                    if (this.e.getLatitude() >= geoPoint.getLatitude()) {
                        this.e.setLatitude(geoPoint.getLatitude());
                    }
                    if (this.e.getLongitude() >= geoPoint.getLongitude()) {
                        this.e.setLongitude(geoPoint.getLongitude());
                    }
                    if (this.f.getLatitude() <= geoPoint.getLatitude()) {
                        this.f.setLatitude(geoPoint.getLatitude());
                    }
                    if (this.f.getLongitude() <= geoPoint.getLongitude()) {
                        this.f.setLongitude(geoPoint.getLongitude());
                    }
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.j
    public String a() {
        InterceptResult invokeV;
        String a;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.k) {
                if (this.g) {
                    if (!b()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.g = z;
                }
                a = a(this.i);
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public void a(ap apVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, apVar) == null) {
            this.a = apVar;
        }
    }
}
