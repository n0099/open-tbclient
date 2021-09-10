package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f;
import c.a.p0.a.g;
import c.a.p0.a.k;
import c.a.p0.a.v2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class BdMultiPicker extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f46243e;

    /* renamed from: f  reason: collision with root package name */
    public JSONArray f46244f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f46245g;

    /* renamed from: h  reason: collision with root package name */
    public int f46246h;

    /* renamed from: i  reason: collision with root package name */
    public b f46247i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f46248j;
    public int k;
    public int l;
    public int m;
    public int n;
    public c.a.p0.a.z1.a.e.c.b o;

    /* loaded from: classes6.dex */
    public class a implements c.a.p0.a.z1.a.e.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdMultiPicker f46249a;

        public a(BdMultiPicker bdMultiPicker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdMultiPicker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46249a = bdMultiPicker;
        }

        @Override // c.a.p0.a.z1.a.e.c.b
        public void a(WheelView3d wheelView3d, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i2) == null) {
                int currentItem = wheelView3d.getCurrentItem();
                int intValue = ((Integer) wheelView3d.getTag()).intValue();
                if (!this.f46249a.h(intValue, currentItem)) {
                    boolean unused = BdMultiPicker.p;
                } else if (this.f46249a.f46247i != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("column", intValue);
                        jSONObject.put(ProgressInfo.JSON_KEY_CURRENT, currentItem);
                    } catch (JSONException e2) {
                        if (BdMultiPicker.p) {
                            e2.printStackTrace();
                        }
                    }
                    if (BdMultiPicker.p) {
                        String str = "onEndFlingListener: params=" + jSONObject.toString();
                    }
                    this.f46249a.f46247i.a(this.f46249a, jSONObject);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1472644917, "Lcom/baidu/swan/apps/res/ui/BdMultiPicker;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1472644917, "Lcom/baidu/swan/apps/res/ui/BdMultiPicker;");
                return;
            }
        }
        p = k.f7077a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdMultiPicker(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46244f = new JSONArray();
        this.f46245g = new JSONArray();
        this.f46246h = 0;
        this.k = 16;
        this.n = 15;
        this.o = new a(this);
        d(context);
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(0);
            LayoutInflater.from(context).inflate(g.aiapps_multipicker_layout, this);
            this.f46243e = (LinearLayout) findViewById(f.wheel_container);
            this.k = n0.f(context, this.k);
            this.n = n0.f(context, this.n);
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.l = n0.f(context, 16.0f);
            this.m = n0.f(context, 14.0f);
            for (int i2 = 0; i2 < this.f46246h; i2++) {
                WheelView3d wheelView3d = new WheelView3d(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                layoutParams.weight = 1.0f;
                wheelView3d.setOnItemSelectedListener(this.o);
                wheelView3d.setTag(Integer.valueOf(i2));
                wheelView3d.setCyclic(false);
                wheelView3d.setCenterTextSize(this.l);
                wheelView3d.setOuterTextSize(this.m);
                wheelView3d.setDividerType(WheelView3d.DividerType.FILL);
                wheelView3d.setDividerColor(0);
                wheelView3d.setGravity(17);
                wheelView3d.setTextColorCenter(-16777216);
                wheelView3d.setTextColorOut(-16777216);
                wheelView3d.setLineSpacingMultiplier(3.0f);
                wheelView3d.setVisibleItem(7);
                f(wheelView3d, i2);
                this.f46243e.addView(wheelView3d, layoutParams);
            }
            this.f46248j = true;
        }
    }

    public final void f(WheelView3d wheelView3d, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, wheelView3d, i2) == null) || this.f46246h < 2) {
            return;
        }
        if (i2 == 0) {
            wheelView3d.setGravityOffset(-this.n);
        }
        if (i2 == this.f46246h - 1) {
            wheelView3d.setGravityOffset(this.n);
        }
    }

    public final boolean g(int i2, JSONArray jSONArray) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, jSONArray)) == null) {
            JSONArray jSONArray2 = this.f46244f;
            if (jSONArray2 != null && i2 >= 0 && i2 <= jSONArray2.length() - 1) {
                try {
                    this.f46244f.put(i2, jSONArray);
                    return true;
                } catch (JSONException e2) {
                    if (p) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public JSONArray getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (p && this.f46245g != null) {
                String str = "getCurrentIndex: index=" + this.f46245g.toString();
            }
            return this.f46245g;
        }
        return (JSONArray) invokeV.objValue;
    }

    public final boolean h(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) {
            JSONArray jSONArray = this.f46245g;
            if (jSONArray != null && i2 >= 0 && i2 <= jSONArray.length() - 1) {
                try {
                    if (this.f46245g.getInt(i2) != i3) {
                        this.f46245g.put(i2, i3);
                        return true;
                    }
                } catch (JSONException e2) {
                    if (p) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final void i(int i2, JSONArray jSONArray, int i3) {
        WheelView3d wheelView3d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), jSONArray, Integer.valueOf(i3)}) == null) || (wheelView3d = (WheelView3d) this.f46243e.getChildAt(i2)) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                arrayList.add(jSONArray.optString(i4));
            }
        } else {
            arrayList.add("");
        }
        if (p) {
            String str = "update wheel UI dataArray : " + jSONArray;
        }
        wheelView3d.setCyclic(false);
        wheelView3d.setAdapter(new c.a.p0.a.z1.a.e.a.a(arrayList));
        wheelView3d.setCurrentItem(i3);
    }

    public void setDataArray(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jSONArray) == null) || jSONArray == null) {
            return;
        }
        this.f46244f = jSONArray;
        this.f46246h = jSONArray.length();
    }

    public void setDataIndex(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONArray) == null) || jSONArray == null) {
            return;
        }
        this.f46245g = jSONArray;
    }

    public void setMultiSelectedListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.f46247i = bVar;
        }
    }

    public void setMultiWheelData(JSONArray jSONArray, JSONArray jSONArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, jSONArray, jSONArray2) == null) {
            if (p) {
                if (jSONArray != null) {
                    String str = "setMultiWheelData: dataArray=" + jSONArray.toString();
                }
                if (jSONArray2 != null) {
                    String str2 = "setMultiWheelData: dataIndex=" + jSONArray2.toString();
                }
            }
            setDataArray(jSONArray);
            setDataIndex(jSONArray2);
            updateUI();
        }
    }

    public void updateUI() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f46246h == 0) {
            return;
        }
        if (!this.f46248j) {
            e(getContext());
        }
        for (int i2 = 0; i2 < this.f46246h; i2++) {
            JSONArray optJSONArray = this.f46244f.optJSONArray(i2);
            ArrayList arrayList = null;
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = optJSONArray.optString(i3);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList2.add(optString);
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
                arrayList.add("");
            }
            WheelView3d wheelView3d = (WheelView3d) this.f46243e.getChildAt(i2);
            wheelView3d.setAdapter(new c.a.p0.a.z1.a.e.a.a(arrayList));
            wheelView3d.setCurrentItem(this.f46245g.optInt(i2));
            wheelView3d.setCyclic(false);
        }
    }

    public void updateWheel(int i2, JSONArray jSONArray, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), jSONArray, Integer.valueOf(i3)}) == null) {
            g(i2, jSONArray);
            h(i2, i3);
            i(i2, jSONArray, i3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdMultiPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f46244f = new JSONArray();
        this.f46245g = new JSONArray();
        this.f46246h = 0;
        this.k = 16;
        this.n = 15;
        this.o = new a(this);
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdMultiPicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f46244f = new JSONArray();
        this.f46245g = new JSONArray();
        this.f46246h = 0;
        this.k = 16;
        this.n = 15;
        this.o = new a(this);
        d(context);
    }
}
