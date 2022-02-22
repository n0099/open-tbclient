package com.baidu.tbadk.core.data;

import android.graphics.Color;
import android.text.SpannableString;
import c.a.u0.a4.j;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes11.dex */
public class SmallTailInfo extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EMOTION_PREFIX = "#(";
    public static final String EMOTION_SUFFIX = ")";
    public static final int TAIL_CONTENT_TYPE_EMOTION = 2;
    public static final int TAIL_CONTENT_TYPE_TEXT = 0;
    public static final long serialVersionUID = -6548060282571779153L;
    public transient /* synthetic */ FieldHolder $fh;
    public String color;
    public List<SmallTailInfoContent> content;
    public int id;
    public int showColorId;
    public transient SpannableString tailSpannable;

    /* loaded from: classes11.dex */
    public class SmallTailInfoContent extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2017172862365526905L;
        public transient /* synthetic */ FieldHolder $fh;
        public String text;
        public final /* synthetic */ SmallTailInfo this$0;
        public int type;

        public SmallTailInfoContent(SmallTailInfo smallTailInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smallTailInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = smallTailInfo;
        }

        public SmallTailInfoContent(SmallTailInfo smallTailInfo, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smallTailInfo, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = smallTailInfo;
            this.text = str;
            this.type = i2;
        }
    }

    public SmallTailInfo() {
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

    private String getShowColorText(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (str == null) {
                return null;
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return TbadkCoreApplication.getInst().getString(j.color_prefix) + TbadkCoreApplication.getInst().getString(j.tail_color_night) + str;
            }
            return TbadkCoreApplication.getInst().getString(j.color_prefix) + str;
        }
        return (String) invokeL.objValue;
    }

    private void updateColor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            try {
                this.showColorId = Color.parseColor(getShowColorText(this.color));
            } catch (Exception unused) {
                this.showColorId = Color.parseColor(getShowColorText(TbadkCoreApplication.getInst().getString(j.tail_color_default)));
            }
        }
    }

    private void updateTailSpannable() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.content == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (SmallTailInfoContent smallTailInfoContent : this.content) {
            int i2 = smallTailInfoContent.type;
            if (i2 == 0) {
                String str = smallTailInfoContent.text;
                if (str != null) {
                    sb.append(str);
                }
            } else if (i2 == 2 && !StringUtils.isNull(smallTailInfoContent.text)) {
                String f2 = TbFaceManager.e().f(smallTailInfoContent.text);
                if (!StringUtils.isNull(f2)) {
                    sb.append(EMOTION_PREFIX + f2 + EMOTION_SUFFIX);
                }
            }
        }
        this.tailSpannable = TbFaceManager.e().l(TbadkCoreApplication.getInst(), sb.toString(), null);
    }

    public void updateShowInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            updateTailSpannable();
            updateColor();
        }
    }
}
