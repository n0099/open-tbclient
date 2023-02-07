package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.tieba.R;
import com.baidu.tieba.gp1;
import com.baidu.tieba.j73;
import com.baidu.tieba.nm3;
import com.baidu.tieba.o73;
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
/* loaded from: classes3.dex */
public class BdMultiPicker extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public JSONArray b;
    public JSONArray c;
    public int d;
    public b e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public o73 k;

    /* loaded from: classes3.dex */
    public interface b {
        void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject);
    }

    /* loaded from: classes3.dex */
    public class a implements o73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdMultiPicker a;

        public a(BdMultiPicker bdMultiPicker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdMultiPicker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdMultiPicker;
        }

        @Override // com.baidu.tieba.o73
        public void a(WheelView3d wheelView3d, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i) == null) {
                int currentItem = wheelView3d.getCurrentItem();
                int intValue = ((Integer) wheelView3d.getTag()).intValue();
                if (!this.a.h(intValue, currentItem)) {
                    if (BdMultiPicker.l) {
                        Log.i("BdMultiPicker", "onEndFling: current index is not updated");
                    }
                } else if (this.a.e != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(CriusAttrConstants.COLUMN, intValue);
                        jSONObject.put(ProgressInfo.JSON_KEY_CURRENT, currentItem);
                    } catch (JSONException e) {
                        if (BdMultiPicker.l) {
                            e.printStackTrace();
                        }
                    }
                    if (BdMultiPicker.l) {
                        Log.i("BdMultiPicker", "onEndFlingListener: params=" + jSONObject.toString());
                    }
                    this.a.e.a(this.a, jSONObject);
                }
            }
        }
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
        l = gp1.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new JSONArray();
        this.c = new JSONArray();
        this.d = 0;
        this.g = 16;
        this.j = 15;
        this.k = new a(this);
        d(context);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = new JSONArray();
        this.c = new JSONArray();
        this.d = 0;
        this.g = 16;
        this.j = 15;
        this.k = new a(this);
        d(context);
    }

    public void setMultiWheelData(JSONArray jSONArray, JSONArray jSONArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, jSONArray, jSONArray2) == null) {
            if (l) {
                if (jSONArray != null) {
                    Log.i("BdMultiPicker", "setMultiWheelData: dataArray=" + jSONArray.toString());
                }
                if (jSONArray2 != null) {
                    Log.i("BdMultiPicker", "setMultiWheelData: dataIndex=" + jSONArray2.toString());
                }
            }
            setDataArray(jSONArray);
            setDataIndex(jSONArray2);
            i();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdMultiPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.b = new JSONArray();
        this.c = new JSONArray();
        this.d = 0;
        this.g = 16;
        this.j = 15;
        this.k = new a(this);
        d(context);
    }

    public final void k(int i, JSONArray jSONArray, int i2) {
        WheelView3d wheelView3d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), jSONArray, Integer.valueOf(i2)}) == null) && (wheelView3d = (WheelView3d) this.a.getChildAt(i)) != null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(jSONArray.optString(i3));
                }
            } else {
                arrayList.add("");
            }
            if (l) {
                Log.d("BdMultiPicker", "update wheel UI dataArray : " + jSONArray);
            }
            wheelView3d.setCyclic(false);
            wheelView3d.setAdapter(new j73(arrayList));
            wheelView3d.setCurrentItem(i2);
        }
    }

    public void j(int i, JSONArray jSONArray, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), jSONArray, Integer.valueOf(i2)}) == null) {
            g(i, jSONArray);
            h(i, i2);
            k(i, jSONArray, i2);
        }
    }

    public void setDataArray(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, jSONArray) == null) && jSONArray != null) {
            this.b = jSONArray;
            this.d = jSONArray.length();
        }
    }

    public void setDataIndex(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jSONArray) == null) && jSONArray != null) {
            this.c = jSONArray;
        }
    }

    public void setMultiSelectedListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(0);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00bc, this);
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09276a);
            this.g = nm3.f(context, this.g);
            this.j = nm3.f(context, this.j);
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.h = nm3.f(context, 16.0f);
            this.i = nm3.f(context, 14.0f);
            for (int i = 0; i < this.d; i++) {
                WheelView3d wheelView3d = new WheelView3d(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                layoutParams.weight = 1.0f;
                wheelView3d.setOnItemSelectedListener(this.k);
                wheelView3d.setTag(Integer.valueOf(i));
                wheelView3d.setCyclic(false);
                wheelView3d.setCenterTextSize(this.h);
                wheelView3d.setOuterTextSize(this.i);
                wheelView3d.setDividerType(WheelView3d.DividerType.FILL);
                wheelView3d.setDividerColor(0);
                wheelView3d.setGravity(17);
                wheelView3d.setTextColorCenter(-16777216);
                wheelView3d.setTextColorOut(-16777216);
                wheelView3d.setLineSpacingMultiplier(3.0f);
                wheelView3d.setVisibleItem(7);
                f(wheelView3d, i);
                this.a.addView(wheelView3d, layoutParams);
            }
            this.f = true;
        }
    }

    public final void f(WheelView3d wheelView3d, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, wheelView3d, i) != null) || this.d < 2) {
            return;
        }
        if (i == 0) {
            wheelView3d.setGravityOffset(-this.j);
        }
        if (i == this.d - 1) {
            wheelView3d.setGravityOffset(this.j);
        }
    }

    public final boolean g(int i, JSONArray jSONArray) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, jSONArray)) == null) {
            JSONArray jSONArray2 = this.b;
            if (jSONArray2 != null && i >= 0 && i <= jSONArray2.length() - 1) {
                try {
                    this.b.put(i, jSONArray);
                    return true;
                } catch (JSONException e) {
                    if (l) {
                        e.printStackTrace();
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
            if (l && this.c != null) {
                Log.i("BdMultiPicker", "getCurrentIndex: index=" + this.c.toString());
            }
            return this.c;
        }
        return (JSONArray) invokeV.objValue;
    }

    public final boolean h(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i, i2)) == null) {
            JSONArray jSONArray = this.c;
            if (jSONArray != null && i >= 0 && i <= jSONArray.length() - 1) {
                try {
                    if (this.c.getInt(i) != i2) {
                        this.c.put(i, i2);
                        return true;
                    }
                } catch (JSONException e) {
                    if (l) {
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.d == 0) {
            return;
        }
        if (!this.f) {
            e(getContext());
        }
        for (int i = 0; i < this.d; i++) {
            JSONArray optJSONArray = this.b.optJSONArray(i);
            ArrayList arrayList = null;
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = optJSONArray.optString(i2);
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
            WheelView3d wheelView3d = (WheelView3d) this.a.getChildAt(i);
            wheelView3d.setAdapter(new j73(arrayList));
            wheelView3d.setCurrentItem(this.c.optInt(i));
            wheelView3d.setCyclic(false);
        }
    }
}
