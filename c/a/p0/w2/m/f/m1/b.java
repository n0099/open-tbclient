package c.a.p0.w2.m.f.m1;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.o0.e1.n.f;
import c.a.p0.h0.e0.j;
import c.a.p0.h0.e0.k;
import c.a.p0.h0.e0.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.h0.e0.b f20247h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, String str, c.a.p0.h0.e0.b bVar) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20247h = bVar;
        }

        @Override // c.a.o0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
                c.a.p0.h0.e0.b bVar = this.f20247h;
                if (bVar instanceof k) {
                    statisticItem = ((k) bVar).S();
                } else if (bVar instanceof l) {
                    statisticItem = ((l) bVar).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static void a(List<ThreadInfo> list, List<n> list2, String str, int i) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65536, null, list, list2, str, i) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                ThreadInfo threadInfo = list.get(i3);
                if (threadInfo != null) {
                    ThreadData threadData2 = new ThreadData();
                    threadData2.floorNum = i3 + 1;
                    threadData2.parserProtobuf(threadInfo);
                    if (threadData2.getForumData() != null && !TextUtils.isEmpty(str)) {
                        threadData2.getForumData().j = str;
                    }
                    if ((k.W(threadData2) || l.R(threadData2)) && threadData2.getType() != ThreadData.TYPE_SHARE_THREAD) {
                        k d2 = d(threadData2, i);
                        if (d2 != null && (threadData = d2.a) != null && threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().f10991b)) {
                            d2.f15321g = threadData2.getTid();
                            d2.position = i2;
                            f(d2);
                            list2.add(d2);
                        }
                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                        c.a.p0.h0.e0.b c2 = c(threadData2, i);
                        if (c2 != null) {
                            c2.f15321g = threadData2.getTid();
                            c2.position = i2;
                            if (c2 instanceof k) {
                                if (threadData2.picCount() == 1) {
                                    h(c2);
                                    c2.j = imageWidthAndHeight[0];
                                    c2.k = imageWidthAndHeight[1];
                                } else if (threadData2.picCount() >= 2) {
                                    g(c2);
                                } else {
                                    i(c2);
                                }
                            } else if (c2 instanceof l) {
                                j(c2);
                            }
                        }
                        if (c2 != null && c2.isValid()) {
                            c2.a.insertItemToTitleOrAbstractText();
                            if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029a), threadData2.getAuthor().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new a(16, threadData2.getAuthor().getUserId(), c2), 0, format.length() - 1, 33);
                                c2.a.insertUsernameIntoTitleOrAbstract(spannableString);
                            }
                            list2.add(c2);
                        }
                        k d3 = d(threadData2, i);
                        if (d3 != null) {
                            d3.f15321g = threadData2.getTid();
                            d3.position = i2;
                            e(d3);
                        }
                        if (d3 != null && d3.isValid()) {
                            list2.add(d3);
                        }
                    }
                    i2++;
                }
            }
        }
    }

    public static List<n> b(List<ThreadInfo> list, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, list, str, i)) == null) {
            LinkedList linkedList = new LinkedList();
            a(list, linkedList, str, i);
            return linkedList;
        }
        return (List) invokeLLI.objValue;
    }

    public static c.a.p0.h0.e0.b c(ThreadData threadData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, threadData, i)) == null) {
            if (threadData == null) {
                return null;
            }
            if (k.W(threadData)) {
                k kVar = new k();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                kVar.a = threadData;
                kVar.C = i;
                return kVar;
            } else if (l.R(threadData)) {
                l lVar = new l(threadData);
                lVar.C = i;
                return lVar;
            } else {
                return null;
            }
        }
        return (c.a.p0.h0.e0.b) invokeLI.objValue;
    }

    public static k d(ThreadData threadData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, threadData, i)) == null) {
            k kVar = new k();
            kVar.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            kVar.C = i;
            return kVar;
        }
        return (k) invokeLI.objValue;
    }

    public static void e(c.a.p0.h0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar) == null) {
            if (bVar instanceof k) {
                ((k) bVar).A = true;
            } else if (bVar instanceof l) {
                ((l) bVar).A = true;
            } else if (bVar instanceof j) {
                ((j) bVar).A = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public static void f(c.a.p0.h0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, bVar) == null) {
            bVar.n = true;
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void g(c.a.p0.h0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, bVar) == null) {
            ((k) bVar).q = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void h(c.a.p0.h0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, bVar) == null) {
            ((k) bVar).p = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void i(c.a.p0.h0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bVar) == null) {
            ((k) bVar).r = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void j(c.a.p0.h0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bVar) == null) {
            ((l) bVar).s = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }
}
