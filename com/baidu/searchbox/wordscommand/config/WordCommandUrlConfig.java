package com.baidu.searchbox.wordscommand.config;

import com.baidu.searchbox.config.HostConfig;
/* loaded from: classes4.dex */
public class WordCommandUrlConfig {

    /* loaded from: classes4.dex */
    public interface TopicBusinessIndexStat {

        /* loaded from: classes4.dex */
        public interface BasicFun {
            public static final int TOPIC = 10;

            /* loaded from: classes4.dex */
            public interface SubFrom {
                public static final int WORDCOMMAND = 1009;
            }
        }
    }

    public static String getWordCommandContentUrl() {
        return String.format("%s/cmptoken/getscheme", HostConfig.getSearchboxHostForHttps());
    }

    public static String getWordCommandRegexUrl() {
        return String.format("%s/cmptoken/getconfig", HostConfig.getSearchboxHostForHttps());
    }

    public static String getWordCommandTokenUrl() {
        return String.format("%s/cmptoken/gettoken", HostConfig.getSearchboxHostForHttps());
    }
}
