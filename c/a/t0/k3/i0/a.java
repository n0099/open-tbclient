package c.a.t0.k3.i0;

import android.util.SparseIntArray;
import c.a.t0.y1.o.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.lego.view.AdCardMultiPicView;
import com.baidu.tieba.recapp.lego.view.AdCardSinglePicView;
import com.baidu.tieba.recapp.lego.view.AdCardSmallPicVideoView;
import com.baidu.tieba.recapp.lego.view.AdCardSmallPicView;
import com.baidu.tieba.recapp.lego.view.AdCardVideoView;
import com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    @Override // c.a.t0.y1.o.e
    public <T> c.a.t0.y1.o.l.e a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i2) {
        InterceptResult invokeLLI;
        c.a.t0.y1.o.l.e formCardView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, tbPageContext, iCardInfo, i2)) == null) {
            int cardType = iCardInfo == null ? -1 : iCardInfo.getCardType();
            if (cardType != 17) {
                if (cardType == 27) {
                    formCardView = new FormCardView(tbPageContext);
                } else if (cardType == 33) {
                    formCardView = new VideoMiddlePageAdView(tbPageContext);
                } else if (cardType != 34) {
                    return null;
                }
                return formCardView;
            }
            return e(tbPageContext, iCardInfo, i2);
        }
        return (c.a.t0.y1.o.l.e) invokeLLI.objValue;
    }

    @Override // c.a.t0.y1.o.e
    public ICardInfo b(JSONObject jSONObject, int i2) throws CardParseException {
        InterceptResult invokeLI;
        ICardInfo adCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i2)) == null) {
            if (i2 != 17) {
                if (i2 == 27) {
                    adCard = new FormCard(jSONObject);
                } else if (i2 == 33) {
                    adCard = new VideoMiddlePageAdCard(jSONObject);
                } else if (i2 != 34) {
                    return null;
                }
                return adCard;
            }
            adCard = new AdCard(jSONObject);
            return adCard;
        }
        return (ICardInfo) invokeLI.objValue;
    }

    @Override // c.a.t0.y1.o.e
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SparseIntArray sparseIntArray = e.a;
            sparseIntArray.put(17, sparseIntArray.size() + 1);
            SparseIntArray sparseIntArray2 = e.a;
            sparseIntArray2.put(27, sparseIntArray2.size() + 1);
            SparseIntArray sparseIntArray3 = e.a;
            sparseIntArray3.put(33, sparseIntArray3.size() + 1);
            SparseIntArray sparseIntArray4 = e.a;
            sparseIntArray4.put(34, sparseIntArray4.size() + 1);
            e.f25439b.put(17, BdUniqueId.gen());
            e.f25439b.put(27, BdUniqueId.gen());
            e.f25439b.put(33, BdUniqueId.gen());
            e.f25439b.put(34, BdUniqueId.gen());
        }
    }

    @Override // c.a.t0.y1.o.e
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "lego_for_RecApp" : (String) invokeV.objValue;
    }

    public final BaseLegoCardView e(TbPageContext<?> tbPageContext, ICardInfo iCardInfo, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, tbPageContext, iCardInfo, i2)) == null) {
            if (iCardInfo instanceof AdCard) {
                AdCard adCard = (AdCard) iCardInfo;
                int cardType = adCard.getCardType();
                if (cardType != 17 && cardType != 34) {
                    BdLog.e("RecAppLegoFactory: specifyAdCardView got wrong card type!");
                    return null;
                }
                int i3 = adCard.goodsStyle;
                if (i3 != 2) {
                    if (i3 != 6) {
                        if (i3 != 7) {
                            if (i3 != 8) {
                                switch (i3) {
                                    case 12:
                                        return new AdCardSmallPicVideoView(tbPageContext);
                                    case 13:
                                        return new AdCardSmallPicView(tbPageContext);
                                    case 14:
                                        break;
                                    default:
                                        return null;
                                }
                            }
                        }
                        return new AdCardVideoView(tbPageContext);
                    }
                    return new AdCardMultiPicView(tbPageContext);
                }
                return new AdCardSinglePicView(tbPageContext);
            }
            return null;
        }
        return (BaseLegoCardView) invokeLLI.objValue;
    }
}
