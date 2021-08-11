package c.a.o0.s.q;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class a extends BaseCardInfo implements c.a.o0.b.f.p {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BIG_IMG = 2;
    public static final int CONTENT = 1;
    public static final int HEAD_IMG = 4;
    public static final int HEAD_VIDEO = 5;
    public static final int USER_NAME = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<String> feedBackReasonMap;
    public int floorPosition;
    public Map<BdUniqueId, c.a.o0.b.e> mABTestMap;
    public int objType;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.objType = 1;
        this.floorPosition = -1;
        this.mABTestMap = new HashMap();
        this.feedBackReasonMap = null;
    }

    private c.a.o0.b.e getCurUsbAbTestSwitchByKey(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return null;
            }
            return this.mABTestMap.get(bdUniqueId);
        }
        return (c.a.o0.b.e) invokeL.objValue;
    }

    public abstract x0 getNegFeedBackData();

    public String getPbInputLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getThreadData() == null) {
                return null;
            }
            return getThreadData().getRecomReason();
        }
        return (String) invokeV.objValue;
    }

    public abstract c2 getThreadData();

    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c2 threadData = getThreadData();
            if (threadData == null) {
                return false;
            }
            return threadData.isFromFrs();
        }
        return invokeV.booleanValue;
    }

    public boolean isSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ThreadCardUtils.isSelf(getThreadData()) : invokeV.booleanValue;
    }

    @Override // c.a.o0.b.f.p
    public void setABTest(BdUniqueId bdUniqueId, c.a.o0.b.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, bdUniqueId, eVar) == null) || bdUniqueId == null) {
            return;
        }
        this.mABTestMap.put(bdUniqueId, eVar);
    }

    public boolean showCardBottomOpWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c2 threadData = getThreadData();
            if (threadData == null) {
                return false;
            }
            return threadData.X1 || threadData.Y1 || threadData.b2 || threadData.Z1 || threadData.c2 || threadData.a2;
        }
        return invokeV.booleanValue;
    }

    public boolean showCardEnterFourm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c2 threadData = getThreadData();
            if (threadData == null) {
                return false;
            }
            return threadData.Y1 || threadData.b2 || threadData.E2();
        }
        return invokeV.booleanValue;
    }

    public boolean showCardGoodsFourm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c2 threadData = getThreadData();
            if (threadData == null) {
                return false;
            }
            return threadData.Y1 || threadData.b2 || threadData.X1;
        }
        return invokeV.booleanValue;
    }

    public boolean showFollowBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c2 threadData = getThreadData();
            if (threadData == null || threadData.J() == null || ThreadCardUtils.isSelf(threadData)) {
                return false;
            }
            boolean z = threadData.O1() || threadData.J1() || threadData.M1();
            if ((!threadData.X1 || (!z && !threadData.E2())) && ((!threadData.Z1 || (!z && !threadData.E2())) && (!threadData.isFromFrs() || (!z && !threadData.E2())))) {
                if (!threadData.a2) {
                    return false;
                }
                if (!z && !threadData.E2()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean showNewPicCut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? c.a.o0.b.d.d(getCurUsbAbTestSwitchByKey(c.a.o0.b.f.m.f12482c), "11_7_index_b") : invokeV.booleanValue;
    }

    public boolean showNewUI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? c.a.o0.b.d.d(getCurUsbAbTestSwitchByKey(c.a.o0.b.f.m.f12482c), "11_7_index_a") : invokeV.booleanValue;
    }

    public boolean showNoName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean showNoReadState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? c.a.o0.b.d.d(getCurUsbAbTestSwitchByKey(c.a.o0.b.f.m.f12482c), "11_7_index_e") : invokeV.booleanValue;
    }

    public boolean showWeakenName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
