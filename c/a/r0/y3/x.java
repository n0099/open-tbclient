package c.a.r0.y3;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.r.p0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? c.a.d.f.p.l.H() ? TbadkCoreApplication.getInst().getVideoAutoPlay() != 1 : c.a.r0.a.h().x() && c.a.d.f.p.l.x() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 : invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            c.a.q0.s.c.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            return !(adAdSense != null && adAdSense.h()) ? c.a.d.f.p.l.H() : (c.a.d.f.p.l.x() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (c.a.d.f.p.l.H() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
        }
        return invokeV.booleanValue;
    }

    public static int c(TbPageContext tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbPageContext, str)) == null) {
            if (tbPageContext == null || TextUtils.isEmpty(str)) {
                return 0;
            }
            if (!str.startsWith("tieba://deeplink?")) {
                return d(tbPageContext, str) ? 3 : 0;
            }
            Uri parse = Uri.parse(str);
            if (c.a.r0.j3.a0.t(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT))) != 1000) {
                return d(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
            }
            return 1;
        }
        return invokeLL.intValue;
    }

    public static boolean d(TbPageContext tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, tbPageContext, str)) == null) {
            String[] strArr = {str};
            if (UrlManager.getInstance().UrlValidated(str)) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, strArr, true);
                return true;
            }
            return UrlManager.getInstance().dealOneLink(tbPageContext, strArr);
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(List<Object> list, int i2) {
        int i3;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, list, i2) == null) || list == null || list.size() == 0) {
            return;
        }
        boolean z2 = MessageManager.getInstance().findTask(2016447) != null;
        int i4 = 0;
        while (i4 < list.size()) {
            if (list.get(i4) instanceof ICardInfo) {
                if (z2) {
                    ICardInfo iCardInfo = (ICardInfo) list.get(i4);
                    int viewCount = iCardInfo.getViewCount();
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < viewCount; i5++) {
                        ICardInfo viewItem = iCardInfo.getViewItem(i5, i2);
                        if (viewItem != null) {
                            viewItem.setBdUniqueId(c.a.r0.z1.o.e.f25387b.get(viewItem.getCardType()));
                            arrayList.add(viewItem);
                        }
                    }
                    if (arrayList.size() != 0) {
                        list.remove(i4);
                        list.addAll(i4, arrayList);
                        i3 = arrayList.size();
                        z = false;
                        if (!z) {
                            list.remove(i4);
                            i3 = 0;
                        }
                    }
                }
                i3 = 1;
                z = true;
                if (!z) {
                }
            } else {
                i3 = 1;
            }
            i4 += i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(List<c.a.d.o.e.n> list, int i2) {
        int i3;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, list, i2) == null) || list == null || list.size() == 0) {
            return;
        }
        boolean z2 = MessageManager.getInstance().findTask(2016447) != null;
        int i4 = 0;
        while (i4 < list.size()) {
            if (list.get(i4) instanceof p0) {
                if (z2) {
                    if (!((p0) list.get(i4)).isValid()) {
                        ((p0) list.get(i4)).i();
                    }
                    if (((p0) list.get(i4)).isValid()) {
                        ICardInfo g2 = ((p0) list.get(i4)).g();
                        int viewCount = g2.getViewCount();
                        ArrayList arrayList = new ArrayList();
                        for (int i5 = 0; i5 < viewCount; i5++) {
                            ICardInfo viewItem = g2.getViewItem(i5, i2);
                            if (viewItem != null) {
                                viewItem.setBdUniqueId(c.a.r0.z1.o.e.f25387b.get(viewItem.getCardType()));
                                arrayList.add(viewItem);
                            }
                        }
                        if (arrayList.size() != 0) {
                            list.remove(i4);
                            list.addAll(i4, arrayList);
                            i3 = arrayList.size();
                            z = false;
                            if (!z) {
                                list.remove(i4);
                                i3 = 0;
                            }
                        }
                    }
                }
                i3 = 1;
                z = true;
                if (!z) {
                }
            } else {
                i3 = 1;
            }
            i4 += i3;
        }
    }

    public static ArrayList<BdUniqueId> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            int size = c.a.r0.z1.o.e.f25387b.size();
            ArrayList<BdUniqueId> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(c.a.r0.z1.o.e.f25387b.valueAt(i2));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
