package c.a.p0.i2.k.e.c1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.o0.s.q.c2;
import c.a.p0.i2.h.e;
import c.a.p0.i2.h.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbPostShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19075a;

    /* renamed from: b  reason: collision with root package name */
    public b f19076b;

    /* loaded from: classes3.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19077a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19077a = cVar;
        }

        @Override // c.a.p0.i2.k.e.c1.c.b
        public void a(e eVar, c2 c2Var, PostData postData, c.a.o0.d1.m.a aVar) {
            String e2;
            String q1;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, c2Var, postData, aVar) == null) {
                if ((eVar == null && c2Var == null) || postData == null || this.f19077a.f19075a == null) {
                    return;
                }
                if (eVar == null) {
                    e2 = this.f19077a.e(c2Var);
                } else {
                    String str2 = eVar.N(this.f19077a.f19075a.getPageActivity(), false)[0];
                    if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str2 = str2.substring(37);
                    }
                    c2 O = eVar.O();
                    if (O == null) {
                        return;
                    }
                    String str3 = str2;
                    c2Var = O;
                    e2 = str3;
                }
                m mVar = new m();
                mVar.h(c2Var.o());
                if (!StringUtils.isNull(e2)) {
                    mVar.k(e2);
                }
                mVar.l(c2Var.m1());
                mVar.g(aVar);
                mVar.i(postData);
                String title = c2Var.getTitle();
                if (StringUtils.isNull(title)) {
                    title = c2Var.o();
                }
                mVar.h(title);
                if (c2Var.z2()) {
                    q1 = c2Var.L().oriUgcTid;
                    str = "?share=9105&fr=dshare&dtype=" + c2Var.L().oriUgcType + "&dvid=" + c2Var.L().oriUgcVid + "&nid=" + c2Var.L().oriUgcNid;
                } else {
                    q1 = c2Var.q1();
                    str = "?share=9105&fr=share";
                }
                mVar.j(this.f19077a.d("http://tieba.baidu.com/p/" + q1 + (str + "&post_id=" + postData.E() + "&share_from=comment&post_sort=1")));
                ShareItem shareItem = new ShareItem();
                shareItem.W = 1;
                shareItem.k = true;
                shareItem.q = q1;
                shareItem.V = postData.E();
                Bundle bundle = new Bundle();
                bundle.putString("tid", q1);
                bundle.putString("pid", postData.E());
                bundle.putInt("source", 1);
                shareItem.k(bundle);
                PbPostShareDialogConfig pbPostShareDialogConfig = new PbPostShareDialogConfig(this.f19077a.f19075a.getPageActivity(), shareItem, true, mVar);
                pbPostShareDialogConfig.setIsCopyLink(false);
                pbPostShareDialogConfig.setHideMode(pbPostShareDialogConfig.hideMode | 32);
                this.f19077a.f19075a.sendMessage(new CustomMessage(2001276, pbPostShareDialogConfig));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem.param("tid", q1);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (c2Var.Y() != null) {
                    statisticItem.param("fid", c2Var.Y().f14092a);
                }
                if (c2Var.t1() != null) {
                    statisticItem.param("post_id", postData.E());
                }
                statisticItem.param("obj_locate", 21);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(e eVar, c2 c2Var, PostData postData, c.a.o0.d1.m.a aVar);
    }

    public c(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19076b = new a(this);
        this.f19075a = tbPageContext;
    }

    public final Bitmap d(String str) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
                return null;
            }
            return (Bitmap) runTask.getData();
        }
        return (Bitmap) invokeL.objValue;
    }

    public final String e(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var)) == null) {
            String str = null;
            if (c2Var == null) {
                return null;
            }
            if (c2Var.j1() != null && !TextUtils.isEmpty(c2Var.j1().cover)) {
                return c2Var.j1().cover;
            }
            if (c2Var.C0() == null) {
                return null;
            }
            ArrayList<MediaData> C0 = c2Var.C0();
            int size = C0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = C0.get(i2);
                if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        str = mediaData.getThumbnails_url();
                        break;
                    } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        str = mediaData.getPicUrl();
                        break;
                    }
                }
                i2++;
            }
            return (str != null || c2Var.o1() == null || TextUtils.isEmpty(c2Var.o1().thumbnail_url)) ? str : c2Var.o1().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }
}
