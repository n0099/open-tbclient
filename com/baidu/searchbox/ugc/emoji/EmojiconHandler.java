package com.baidu.searchbox.ugc.emoji;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.emoji.edittextrule.AtRule;
import com.baidu.searchbox.ugc.emoji.edittextrule.TopicRule;
import com.baidu.searchbox.ugc.model.AtUserInfoItem;
import com.baidu.searchbox.ugc.model.TopicItem;
/* loaded from: classes13.dex */
public final class EmojiconHandler {
    private static final SparseIntArray EMOJISMAP = new SparseIntArray(120);
    private static AddTopicItemListener mAddTopicItemListener;

    /* loaded from: classes13.dex */
    public interface AddTopicItemListener {
        void onAddTopicItem(int i, int i2);
    }

    private EmojiconHandler() {
    }

    static {
        EMOJISMAP.put(128515, R.drawable.ugc_emoji_1f603);
        EMOJISMAP.put(128522, R.drawable.ugc_emoji_1f60a);
        EMOJISMAP.put(9786, R.drawable.ugc_emoji_263a);
        EMOJISMAP.put(128521, R.drawable.ugc_emoji_1f609);
        EMOJISMAP.put(128525, R.drawable.ugc_emoji_1f60d);
        EMOJISMAP.put(128536, R.drawable.ugc_emoji_1f618);
        EMOJISMAP.put(128538, R.drawable.ugc_emoji_1f61a);
        EMOJISMAP.put(128540, R.drawable.ugc_emoji_1f61c);
        EMOJISMAP.put(128541, R.drawable.ugc_emoji_1f61d);
        EMOJISMAP.put(128563, R.drawable.ugc_emoji_1f633);
        EMOJISMAP.put(128513, R.drawable.ugc_emoji_1f601);
        EMOJISMAP.put(128532, R.drawable.ugc_emoji_1f614);
        EMOJISMAP.put(128524, R.drawable.ugc_emoji_1f60c);
        EMOJISMAP.put(128530, R.drawable.ugc_emoji_1f612);
        EMOJISMAP.put(128547, R.drawable.ugc_emoji_1f623);
        EMOJISMAP.put(128546, R.drawable.ugc_emoji_1f622);
        EMOJISMAP.put(128514, R.drawable.ugc_emoji_1f602);
        EMOJISMAP.put(128557, R.drawable.ugc_emoji_1f62d);
        EMOJISMAP.put(128554, R.drawable.ugc_emoji_1f62a);
        EMOJISMAP.put(128549, R.drawable.ugc_emoji_1f625);
        EMOJISMAP.put(128560, R.drawable.ugc_emoji_1f630);
        EMOJISMAP.put(128517, R.drawable.ugc_emoji_1f605);
        EMOJISMAP.put(128531, R.drawable.ugc_emoji_1f613);
        EMOJISMAP.put(128555, R.drawable.ugc_emoji_1f62b);
        EMOJISMAP.put(128552, R.drawable.ugc_emoji_1f628);
        EMOJISMAP.put(128561, R.drawable.ugc_emoji_1f631);
        EMOJISMAP.put(128544, R.drawable.ugc_emoji_1f620);
        EMOJISMAP.put(128545, R.drawable.ugc_emoji_1f621);
        EMOJISMAP.put(128548, R.drawable.ugc_emoji_1f624);
        EMOJISMAP.put(128534, R.drawable.ugc_emoji_1f616);
        EMOJISMAP.put(128518, R.drawable.ugc_emoji_1f606);
        EMOJISMAP.put(128523, R.drawable.ugc_emoji_1f60b);
        EMOJISMAP.put(128567, R.drawable.ugc_emoji_1f637);
        EMOJISMAP.put(128526, R.drawable.ugc_emoji_1f60e);
        EMOJISMAP.put(128564, R.drawable.ugc_emoji_1f634);
        EMOJISMAP.put(128565, R.drawable.ugc_emoji_1f635);
        EMOJISMAP.put(128562, R.drawable.ugc_emoji_1f632);
        EMOJISMAP.put(128543, R.drawable.ugc_emoji_1f61f);
        EMOJISMAP.put(128520, R.drawable.ugc_emoji_1f608);
        EMOJISMAP.put(128556, R.drawable.ugc_emoji_1f62c);
        EMOJISMAP.put(128528, R.drawable.ugc_emoji_1f610);
        EMOJISMAP.put(128533, R.drawable.ugc_emoji_1f615);
        EMOJISMAP.put(128559, R.drawable.ugc_emoji_1f62f);
        EMOJISMAP.put(128519, R.drawable.ugc_emoji_1f607);
        EMOJISMAP.put(128527, R.drawable.ugc_emoji_1f60f);
        EMOJISMAP.put(128124, R.drawable.ugc_emoji_1f47c);
        EMOJISMAP.put(128169, R.drawable.ugc_emoji_1f4a9);
        EMOJISMAP.put(128293, R.drawable.ugc_emoji_1f525);
        EMOJISMAP.put(10024, R.drawable.ugc_emoji_2728);
        EMOJISMAP.put(128165, R.drawable.ugc_emoji_1f4a5);
        EMOJISMAP.put(128162, R.drawable.ugc_emoji_1f4a2);
        EMOJISMAP.put(128166, R.drawable.ugc_emoji_1f4a6);
        EMOJISMAP.put(128167, R.drawable.ugc_emoji_1f4a7);
        EMOJISMAP.put(128164, R.drawable.ugc_emoji_1f4a4);
        EMOJISMAP.put(128168, R.drawable.ugc_emoji_1f4a8);
        EMOJISMAP.put(128064, R.drawable.ugc_emoji_1f440);
        EMOJISMAP.put(128068, R.drawable.ugc_emoji_1f444);
        EMOJISMAP.put(128077, R.drawable.ugc_emoji_1f44d);
        EMOJISMAP.put(128078, R.drawable.ugc_emoji_1f44e);
        EMOJISMAP.put(128076, R.drawable.ugc_emoji_1f44c);
        EMOJISMAP.put(128074, R.drawable.ugc_emoji_1f44a);
        EMOJISMAP.put(128075, R.drawable.ugc_emoji_1f44b);
        EMOJISMAP.put(128591, R.drawable.ugc_emoji_1f64f);
        EMOJISMAP.put(128079, R.drawable.ugc_emoji_1f44f);
        EMOJISMAP.put(128170, R.drawable.ugc_emoji_1f4aa);
        EMOJISMAP.put(127939, R.drawable.ugc_emoji_1f3c3);
        EMOJISMAP.put(128582, R.drawable.ugc_emoji_1f646);
        EMOJISMAP.put(128581, R.drawable.ugc_emoji_1f645);
        EMOJISMAP.put(128583, R.drawable.ugc_emoji_1f647);
        EMOJISMAP.put(128081, R.drawable.ugc_emoji_1f451);
        EMOJISMAP.put(128089, R.drawable.ugc_emoji_1f459);
        EMOJISMAP.put(127872, R.drawable.ugc_emoji_1f380);
        EMOJISMAP.put(127746, R.drawable.ugc_emoji_1f302);
        EMOJISMAP.put(10084, R.drawable.ugc_emoji_2764);
        EMOJISMAP.put(128139, R.drawable.ugc_emoji_1f48b);
        EMOJISMAP.put(128141, R.drawable.ugc_emoji_1f48d);
        EMOJISMAP.put(128099, R.drawable.ugc_emoji_1f463);
        EMOJISMAP.put(128054, R.drawable.ugc_emoji_1f436);
        EMOJISMAP.put(128055, R.drawable.ugc_emoji_1f437);
        EMOJISMAP.put(128053, R.drawable.ugc_emoji_1f435);
        EMOJISMAP.put(128052, R.drawable.ugc_emoji_1f434);
        EMOJISMAP.put(127800, R.drawable.ugc_emoji_1f338);
        EMOJISMAP.put(127808, R.drawable.ugc_emoji_1f340);
        EMOJISMAP.put(127801, R.drawable.ugc_emoji_1f339);
        EMOJISMAP.put(127809, R.drawable.ugc_emoji_1f341);
        EMOJISMAP.put(127810, R.drawable.ugc_emoji_1f342);
        EMOJISMAP.put(127794, R.drawable.ugc_emoji_1f332);
        EMOJISMAP.put(127769, R.drawable.ugc_emoji_1f319);
        EMOJISMAP.put(9925, R.drawable.ugc_emoji_26c5);
        EMOJISMAP.put(9889, R.drawable.ugc_emoji_26a1);
        EMOJISMAP.put(9748, R.drawable.ugc_emoji_2614);
        EMOJISMAP.put(9924, R.drawable.ugc_emoji_26c4);
        EMOJISMAP.put(127752, R.drawable.ugc_emoji_1f308);
        EMOJISMAP.put(127878, R.drawable.ugc_emoji_1f386);
        EMOJISMAP.put(127879, R.drawable.ugc_emoji_1f387);
        EMOJISMAP.put(127875, R.drawable.ugc_emoji_1f383);
        EMOJISMAP.put(127877, R.drawable.ugc_emoji_1f385);
        EMOJISMAP.put(127876, R.drawable.ugc_emoji_1f384);
        EMOJISMAP.put(127873, R.drawable.ugc_emoji_1f381);
        EMOJISMAP.put(127881, R.drawable.ugc_emoji_1f389);
        EMOJISMAP.put(128247, R.drawable.ugc_emoji_1f4f7);
        EMOJISMAP.put(9742, R.drawable.ugc_emoji_260e);
        EMOJISMAP.put(128163, R.drawable.ugc_emoji_1f4a3);
        EMOJISMAP.put(128298, R.drawable.ugc_emoji_1f52a);
        EMOJISMAP.put(128176, R.drawable.ugc_emoji_1f4b0);
        EMOJISMAP.put(127936, R.drawable.ugc_emoji_1f3c0);
        EMOJISMAP.put(127937, R.drawable.ugc_emoji_1f3c1);
        EMOJISMAP.put(127938, R.drawable.ugc_emoji_1f3c2);
        EMOJISMAP.put(9749, R.drawable.ugc_emoji_2615);
        EMOJISMAP.put(127863, R.drawable.ugc_emoji_1f377);
        EMOJISMAP.put(127874, R.drawable.ugc_emoji_1f382);
        EMOJISMAP.put(127853, R.drawable.ugc_emoji_1f36d);
        EMOJISMAP.put(127817, R.drawable.ugc_emoji_1f349);
        EMOJISMAP.put(9888, R.drawable.ugc_emoji_26a0);
        EMOJISMAP.put(128205, R.drawable.ugc_emoji_1f4cd);
        EMOJISMAP.put(9940, R.drawable.ugc_emoji_26d4);
        EMOJISMAP.put(10062, R.drawable.ugc_emoji_274e);
        EMOJISMAP.put(9989, R.drawable.ugc_emoji_2705);
        EMOJISMAP.put(10133, R.drawable.ugc_emoji_2795);
    }

    private static int getEmojiResource(Context context, int i) {
        return EMOJISMAP.get(i);
    }

    public static void addEmojis(Context context, Spannable spannable, int i) {
        int i2;
        int i3;
        int i4;
        int length = spannable.length();
        for (EmojiconSpan emojiconSpan : (EmojiconSpan[]) spannable.getSpans(0, length, EmojiconSpan.class)) {
            spannable.removeSpan(emojiconSpan);
        }
        int i5 = 0;
        while (i5 < length) {
            int codePointAt = Character.codePointAt(spannable, i5);
            int charCount = Character.charCount(codePointAt);
            int emojiResource = codePointAt > 255 ? getEmojiResource(context, codePointAt) : 0;
            if (emojiResource != 0 || i5 + charCount >= length) {
                i2 = charCount;
            } else {
                int codePointAt2 = Character.codePointAt(spannable, i5 + charCount);
                if (codePointAt2 == 8419) {
                    i2 = Character.charCount(codePointAt2) + charCount;
                } else {
                    int charCount2 = Character.charCount(codePointAt2);
                    switch (codePointAt) {
                        case 127464:
                            i3 = codePointAt2 == 127475 ? R.drawable.ugc_emoji_1f1e8_1f1f3 : 0;
                            i4 = charCount2;
                            break;
                        default:
                            i3 = emojiResource;
                            i4 = 0;
                            break;
                    }
                    int i6 = i3;
                    i2 = i4 + charCount;
                    emojiResource = i6;
                }
            }
            if (emojiResource > 0) {
                spannable.setSpan(new EmojiconSpan(context, emojiResource, i), i5, i5 + i2, 33);
            }
            i5 += i2;
        }
    }

    public static void addEmojis(Context context, Spannable spannable, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8 = i2 + i4;
        int i9 = i2 + i3;
        while (i9 < i8) {
            int codePointAt = Character.codePointAt(spannable, i9);
            int charCount = Character.charCount(codePointAt);
            int emojiResource = codePointAt > 255 ? getEmojiResource(context, codePointAt) : 0;
            if (emojiResource != 0 || i9 + charCount >= i8) {
                i5 = charCount;
            } else {
                int codePointAt2 = Character.codePointAt(spannable, i9 + charCount);
                if (codePointAt2 == 8419) {
                    i5 = Character.charCount(codePointAt2) + charCount;
                } else {
                    int charCount2 = Character.charCount(codePointAt2);
                    switch (codePointAt) {
                        case 127464:
                            i6 = codePointAt2 == 127475 ? R.drawable.ugc_emoji_1f1e8_1f1f3 : 0;
                            i7 = charCount2;
                            break;
                        default:
                            i6 = emojiResource;
                            i7 = 0;
                            break;
                    }
                    int i10 = i6;
                    i5 = i7 + charCount;
                    emojiResource = i10;
                }
            }
            if (emojiResource > 0) {
                spannable.setSpan(new EmojiconSpan(context, emojiResource, i), i9, i9 + i5, 33);
            }
            i9 += i5;
        }
    }

    public static void addTopic(EmojiconEditText emojiconEditText, TopicItem topicItem, TopicRule topicRule) {
        if (topicItem != null && !TextUtils.isEmpty(topicItem.name)) {
            if (topicRule != null && emojiconEditText.containsRule(topicRule)) {
                topicRule.addTopicItem(topicItem);
            }
            Editable text = emojiconEditText.getText();
            int selectionStart = emojiconEditText.getSelectionStart();
            if (text != null) {
                if (selectionStart < 0 || selectionStart >= text.toString().length()) {
                    text.append((CharSequence) (topicItem.name + HanziToPinyin.Token.SEPARATOR));
                } else {
                    text.insert(selectionStart, topicItem.name + HanziToPinyin.Token.SEPARATOR);
                }
                int length = topicItem.name.length() + selectionStart;
                if (mAddTopicItemListener != null) {
                    mAddTopicItemListener.onAddTopicItem(selectionStart, length);
                }
            }
        }
    }

    public static void addAt(EmojiconEditText emojiconEditText, AtUserInfoItem atUserInfoItem, AtRule atRule) {
        if (atUserInfoItem != null && !TextUtils.isEmpty(atUserInfoItem.nickname) && !TextUtils.isEmpty(atUserInfoItem.uk)) {
            if (atRule != null && emojiconEditText.containsRule(atRule)) {
                atRule.addAtItem(atUserInfoItem);
            }
            Editable text = emojiconEditText.getText();
            int selectionStart = emojiconEditText.getSelectionStart();
            if (text != null) {
                if (selectionStart < 0 || selectionStart >= text.toString().length()) {
                    text.append((CharSequence) (atUserInfoItem.nickname + HanziToPinyin.Token.SEPARATOR));
                } else {
                    text.insert(selectionStart, atUserInfoItem.nickname + HanziToPinyin.Token.SEPARATOR);
                }
            }
        }
    }

    public static void setAddTopicItemListener(AddTopicItemListener addTopicItemListener) {
        mAddTopicItemListener = addTopicItemListener;
    }

    public static void removeAddTopicItemListener() {
        mAddTopicItemListener = null;
    }
}
