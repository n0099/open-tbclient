package c.m.a.g;

import android.graphics.Matrix;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.Layout;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double a;

    /* renamed from: b  reason: collision with root package name */
    public c.m.a.h.c f31062b;

    /* renamed from: c  reason: collision with root package name */
    public Matrix f31063c;

    /* renamed from: d  reason: collision with root package name */
    public b f31064d;

    /* renamed from: e  reason: collision with root package name */
    public List<SVGAVideoShapeEntity> f31065e;

    public g(JSONObject jSONObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        g gVar = this;
        gVar.f31062b = new c.m.a.h.c(0.0d, 0.0d, 0.0d, 0.0d);
        gVar.f31063c = new Matrix();
        gVar.f31065e = CollectionsKt__CollectionsKt.emptyList();
        gVar.a = jSONObject.optDouble(AnimationProperty.OPACITY, 0.0d);
        JSONObject optJSONObject = jSONObject.optJSONObject("layout");
        if (optJSONObject != null) {
            gVar.f31062b = new c.m.a.h.c(optJSONObject.optDouble("x", 0.0d), optJSONObject.optDouble("y", 0.0d), optJSONObject.optDouble("width", 0.0d), optJSONObject.optDouble("height", 0.0d));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(AnimationProperty.TRANSFORM);
        if (optJSONObject2 != null) {
            double optDouble = optJSONObject2.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject2.optDouble("b", 0.0d);
            double optDouble3 = optJSONObject2.optDouble("c", 0.0d);
            double optDouble4 = optJSONObject2.optDouble("d", 1.0d);
            double optDouble5 = optJSONObject2.optDouble("tx", 0.0d);
            double optDouble6 = optJSONObject2.optDouble("ty", 0.0d);
            float f2 = (float) optDouble3;
            z = true;
            float f3 = (float) 0.0d;
            float[] fArr = {(float) optDouble, f2, (float) optDouble5, (float) optDouble2, (float) optDouble4, (float) optDouble6, f3, f3, (float) 1.0d};
            gVar = this;
            gVar.f31063c.setValues(fArr);
        } else {
            z = true;
        }
        String optString = jSONObject.optString("clipPath");
        if (optString != null) {
            if (optString.length() <= 0 ? false : z) {
                gVar.f31064d = new b(optString);
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("shapes");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i4);
                if (optJSONObject3 != null) {
                    arrayList.add(new SVGAVideoShapeEntity(optJSONObject3));
                }
            }
            gVar.f31065e = CollectionsKt___CollectionsKt.toList(arrayList);
        }
    }

    public final double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.doubleValue;
    }

    public final c.m.a.h.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31062b : (c.m.a.h.c) invokeV.objValue;
    }

    public final b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31064d : (b) invokeV.objValue;
    }

    public final List<SVGAVideoShapeEntity> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31065e : (List) invokeV.objValue;
    }

    public final Matrix e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31063c : (Matrix) invokeV.objValue;
    }

    public final void f(List<SVGAVideoShapeEntity> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f31065e = list;
        }
    }

    public g(FrameEntity frameEntity) {
        Float f2;
        Float f3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameEntity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31062b = new c.m.a.h.c(0.0d, 0.0d, 0.0d, 0.0d);
        this.f31063c = new Matrix();
        this.f31065e = CollectionsKt__CollectionsKt.emptyList();
        this.a = frameEntity.alpha != null ? f2.floatValue() : 0.0f;
        Layout layout = frameEntity.layout;
        if (layout != null) {
            Float f4 = layout.x;
            double floatValue = f4 != null ? f4.floatValue() : 0.0f;
            Float f5 = layout.y;
            double floatValue2 = f5 != null ? f5.floatValue() : 0.0f;
            Float f6 = layout.width;
            this.f31062b = new c.m.a.h.c(floatValue, floatValue2, f6 != null ? f6.floatValue() : 0.0f, layout.height != null ? f3.floatValue() : 0.0f);
        }
        Transform transform = frameEntity.transform;
        if (transform != null) {
            float[] fArr = new float[9];
            Float f7 = transform.a;
            float floatValue3 = f7 != null ? f7.floatValue() : 1.0f;
            Float f8 = transform.f61241b;
            float floatValue4 = f8 != null ? f8.floatValue() : 0.0f;
            Float f9 = transform.f61242c;
            float floatValue5 = f9 != null ? f9.floatValue() : 0.0f;
            Float f10 = transform.f61243d;
            float floatValue6 = f10 != null ? f10.floatValue() : 1.0f;
            Float f11 = transform.tx;
            float floatValue7 = f11 != null ? f11.floatValue() : 0.0f;
            Float f12 = transform.ty;
            float floatValue8 = f12 != null ? f12.floatValue() : 0.0f;
            fArr[0] = floatValue3;
            fArr[1] = floatValue5;
            fArr[2] = floatValue7;
            fArr[3] = floatValue4;
            fArr[4] = floatValue6;
            fArr[5] = floatValue8;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            this.f31063c.setValues(fArr);
        }
        String str = frameEntity.clipPath;
        if (str != null) {
            str = str.length() > 0 ? str : null;
            if (str != null) {
                this.f31064d = new b(str);
            }
        }
        List<ShapeEntity> list = frameEntity.shapes;
        Intrinsics.checkExpressionValueIsNotNull(list, "obj.shapes");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (ShapeEntity it : list) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            arrayList.add(new SVGAVideoShapeEntity(it));
        }
        this.f31065e = arrayList;
    }
}
