package com.baidu.tbadk.core.data;

import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.FrsPage.FrsSpriteBubble;
import tbclient.SpriteBubble;
import tbclient.SpriteButton;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class FrsSpriteNewUserGuide implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 6892499244598249340L;
    public transient /* synthetic */ FieldHolder $fh;
    public int bubblePeriod;
    @Nullable
    public BubbleText bubbleText;

    /* loaded from: classes4.dex */
    public static class BubbleText implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5888715266224424002L;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public ThemeColorInfo bgUrlTheme;
        @Nullable
        public ButtonInfo buttonInfo;
        public int disappearSeconds;
        public int needSend;
        @Nullable
        public String sendText;
        public int speechType;
        @Nullable
        public String spriteText;
        @Nullable
        public String text;
        @Nullable
        public ThemeColorInfo textColor;
        @Nullable
        public String title;

        public BubbleText() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.disappearSeconds = -1;
        }

        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return StringUtils.isNotNull(this.text);
            }
            return invokeV.booleanValue;
        }

        @Nullable
        public static BubbleText parse(@Nullable SpriteBubble spriteBubble) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, spriteBubble)) == null) {
                if (spriteBubble == null) {
                    return null;
                }
                BubbleText bubbleText = new BubbleText();
                bubbleText.title = spriteBubble.title;
                bubbleText.text = spriteBubble.text;
                bubbleText.needSend = spriteBubble.need_send.intValue();
                bubbleText.sendText = spriteBubble.send_text;
                bubbleText.textColor = spriteBubble.text_color;
                bubbleText.bgUrlTheme = spriteBubble.icon_url;
                bubbleText.spriteText = spriteBubble.sprite_text;
                bubbleText.buttonInfo = ButtonInfo.parse(spriteBubble.button_info);
                bubbleText.speechType = spriteBubble.speech_type.intValue();
                bubbleText.disappearSeconds = spriteBubble.disappear_seconds.intValue();
                return bubbleText;
            }
            return (BubbleText) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class ButtonInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8073529259196500008L;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public String schema;
        @Nullable
        public String text;

        public ButtonInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return StringUtils.isNotNull(this.text);
            }
            return invokeV.booleanValue;
        }

        @Nullable
        public static ButtonInfo parse(@Nullable SpriteButton spriteButton) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, spriteButton)) == null) {
                if (spriteButton == null) {
                    return null;
                }
                ButtonInfo buttonInfo = new ButtonInfo();
                buttonInfo.text = spriteButton.text;
                buttonInfo.schema = spriteButton.schema;
                return buttonInfo;
            }
            return (ButtonInfo) invokeL.objValue;
        }
    }

    public FrsSpriteNewUserGuide() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BubbleText bubbleText = this.bubbleText;
            if (bubbleText != null && bubbleText.isValid()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public static FrsSpriteNewUserGuide parse(@Nullable FrsSpriteBubble frsSpriteBubble) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsSpriteBubble)) == null) {
            if (frsSpriteBubble == null) {
                return null;
            }
            FrsSpriteNewUserGuide frsSpriteNewUserGuide = new FrsSpriteNewUserGuide();
            frsSpriteNewUserGuide.bubbleText = BubbleText.parse(frsSpriteBubble.bubble_text);
            frsSpriteNewUserGuide.bubblePeriod = frsSpriteBubble.bubble_seconds.intValue();
            return frsSpriteNewUserGuide;
        }
        return (FrsSpriteNewUserGuide) invokeL.objValue;
    }
}
