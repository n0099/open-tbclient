package com.baidu.searchbox.wordscommand.event;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u0000B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0001HÆ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0001HÖ\u0001¢\u0006\u0004\b\f\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0003¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/wordscommand/event/WordCommandEvent;", "", "component1", "()I", "code", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(I)Lcom/baidu/searchbox/wordscommand/event/WordCommandEvent;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getCode", "<init>", "(I)V", "lib-wordcommand_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class WordCommandEvent {
    public final int code;

    public static /* synthetic */ WordCommandEvent copy$default(WordCommandEvent wordCommandEvent, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = wordCommandEvent.code;
        }
        return wordCommandEvent.copy(i);
    }

    public final int component1() {
        return this.code;
    }

    public final WordCommandEvent copy(int i) {
        return new WordCommandEvent(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof WordCommandEvent) && this.code == ((WordCommandEvent) obj).code;
        }
        return true;
    }

    public int hashCode() {
        return this.code;
    }

    public String toString() {
        return "WordCommandEvent(code=" + this.code + SmallTailInfo.EMOTION_SUFFIX;
    }

    public WordCommandEvent(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
